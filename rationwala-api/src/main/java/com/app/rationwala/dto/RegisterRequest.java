package com.app.rationwala.dto;

import com.app.rationwala.model.LoginCredential;
import com.app.rationwala.model.UserProfile;

public class RegisterRequest {

	private LoginCredential loginCredential;
	private UserProfile userProfile;

	public RegisterRequest() {
	}

	public RegisterRequest(LoginCredential loginCredential, UserProfile userProfile) {
		super();
		this.loginCredential = loginCredential;
		this.userProfile = userProfile;
	}

	public LoginCredential getLoginCredential() {
		return loginCredential;
	}

	public void setLoginCredential(LoginCredential loginCredential) {
		this.loginCredential = loginCredential;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
