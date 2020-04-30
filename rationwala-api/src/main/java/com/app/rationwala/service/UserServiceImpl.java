package com.app.rationwala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.dto.LoginResponse;
import com.app.rationwala.dto.Message;
import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;
import com.app.rationwala.dto.StatusInfo;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.modeller.UserProfileModeller;
import com.app.rationwala.repository.UserLoginRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	Environment env;

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	private UserProfileModeller userProfileModeller;

	public UserServiceImpl() {
		userProfileModeller = new UserProfileModeller();
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		LoginResponse res = new LoginResponse();
		res.setLoginCredential(request.getLoginCredential());
		res.setStatusInfo(new StatusInfo());
		UserLogin userLogin = userLoginRepository.findByUserName(request.getLoginCredential().getUsername());
		if (null == userLogin) {
			res.getStatusInfo().setStatus(Status.FAILURE);
			res.getStatusInfo().setMessage(new Message("ER001", env.getProperty("ER001")));
			return res;
		}
		UserProfile userProfile = null;
		if (userLogin.getPassword().equals(request.getLoginCredential().getPassword())) {
			userProfile = userLogin.getUserProfile();
		}
		if (null == userProfile) {
			res.getStatusInfo().setStatus(Status.FAILURE);
			res.getStatusInfo().setMessage(new Message("ER002", env.getProperty("ER002")));
			return res;
		}
		res.setUserProfile(userProfileModeller.marshall(userProfile));
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
		res.setUserProfile(new UserProfileModeller().marshall(resp));
		return res;
	}

}
