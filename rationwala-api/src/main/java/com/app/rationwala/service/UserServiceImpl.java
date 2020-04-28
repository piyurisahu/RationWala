package com.app.rationwala.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.dto.LoginResponse;
import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.modeller.UserProfileModeller;
import com.app.rationwala.repository.UserLoginRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class UserServiceImpl implements UserService {

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
		UserLogin userLogin = userLoginRepository.findByUserNameAndPassword(request.getLoginCredential().getUsername(),
				request.getLoginCredential().getPassword());
		UserProfile userProfile = userProfileRepository.findByUserId(userLogin);
		res.setUserProfile(userProfileModeller.marshall(userProfile));
		res.setLoginCredential(userProfileModeller.marshall(userProfile.getUserLogin()));
		return res;
	}

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
