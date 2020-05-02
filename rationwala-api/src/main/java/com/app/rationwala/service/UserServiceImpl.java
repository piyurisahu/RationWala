package com.app.rationwala.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.app.rationwala.dto.AuthorizeStaffRequest;
import com.app.rationwala.dto.AuthorizeStaffResponse;
import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.dto.LoginResponse;
import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.entity.StaffAuth;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.model.Message;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.modeller.ProfileModeller;
import com.app.rationwala.repository.StaffAuthRepository;
import com.app.rationwala.repository.UserLoginRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	Environment env;

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private StaffAuthRepository staffAuthRepository;

	private ProfileModeller profileModeller;

	public UserServiceImpl() {
		profileModeller = new ProfileModeller();
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		LoginResponse res = new LoginResponse();
		res.setLoginCredential(request.getLoginCredential());
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		UserLogin userLogin = userLoginRepository.findByUserName(request.getLoginCredential().getUsername());
		if (null == userLogin) {
			res.getStatusInfo().setStatus(Status.FAILURE);
			res.getStatusInfo().getMessages().add(new Message("ER001", env.getProperty("ER001")));
			return res;
		}
		if (!userLogin.getPassword().equals(request.getLoginCredential().getPassword())) {
			res.getStatusInfo().setStatus(Status.FAILURE);
			res.getStatusInfo().getMessages().add(new Message("ER002", env.getProperty("ER002")));
			return res;
		}
		UserProfile userProfile = userProfileRepository.findByUserId(userLogin);
		res.setUserProfile(profileModeller.marshallUserProfile(userProfile));
		res.setItemInventoryList(profileModeller.marshallItemInventory(userProfile.getItemInventory()));
		res.setStaffProfiles(profileModeller.marshallStaffProfiles(userProfile.getStaff()));
		res.setSellerProfiles(profileModeller.marshallSellerProfiles(userProfile.getSellerProfiles()));
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		RegisterResponse res = new RegisterResponse();
		com.app.rationwala.model.UserProfile modelUserProfile = registerRequest.getUserProfile();
		UserProfile resp = userProfileRepository.save(new UserProfile(
				new UserLogin(registerRequest.getLoginCredential().getUsername(),
						registerRequest.getLoginCredential().getPassword()),
				modelUserProfile.getFirstName(), modelUserProfile.getLastName(), modelUserProfile.getEmail(),
				modelUserProfile.getPhoneNumber(), modelUserProfile.getAddressLine1(),
				modelUserProfile.getAddressLine2(), modelUserProfile.getZipcode()));
		res.setUserProfile(new ProfileModeller().marshallUserProfile(resp));
		return res;
	}

	@Override
	public AuthorizeStaffResponse authorizeStaff(AuthorizeStaffRequest authorizeUserRequest) {
		AuthorizeStaffResponse res = new AuthorizeStaffResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		final UserProfile sellerProfile;
		try {
			sellerProfile = userProfileRepository.findById(authorizeUserRequest.getSellerUserProfileId()).get();
			if (!sellerProfile.isSellerProfile())
				throw new NoSuchElementException();
		} catch (NoSuchElementException e) {
			res.getStatusInfo().setStatus(Status.FAILURE);
			res.getStatusInfo().getMessages().add(new Message(Status.ERROR,
					String.valueOf(authorizeUserRequest.getSellerUserProfileId()), "ER003", env.getProperty("ER003")));
			return res;
		}
		authorizeUserRequest.getStaffAuthorization().forEach(staffAuthorization -> {
			if (null == staffAuthorization.getStaffAuthType()) {
				res.getStatusInfo().setStatus(Status.FAILURE);
				res.getStatusInfo().getMessages().add(new Message(Status.ERROR,
						String.valueOf(staffAuthorization.getStaffUserProfileId()), "ER004", env.getProperty("ER004")));
				return;
			}
			UserProfile staffProfile = null;
			try {
				staffProfile = userProfileRepository.findById(staffAuthorization.getStaffUserProfileId()).get();
				if (staffProfile.isSellerProfile())
					throw new NoSuchElementException();
			} catch (NoSuchElementException e) {
				res.getStatusInfo().setStatus(Status.FAILURE);
				res.getStatusInfo().getMessages().add(new Message(Status.ERROR,
						String.valueOf(staffAuthorization.getStaffUserProfileId()), "ER005", env.getProperty("ER005")));
				return;
			}
			staffAuthRepository
					.save(new StaffAuth(sellerProfile, staffProfile, staffAuthorization.getStaffAuthType().name()));
			res.getStatusInfo().setStatus(Status.SUCCESS);
		});

		return res;
	}

}
