package com.app.rationwala.dto;

import com.app.rationwala.model.LoginCredential;
import com.app.rationwala.model.UserProfile;

import lombok.Data;

public @Data class RegisterRequest {

	private LoginCredential loginCredential;
	private UserProfile userProfile;

	public RegisterRequest() {
	}

	public RegisterRequest(LoginCredential loginCredential, UserProfile userProfile) {
		super();
		this.loginCredential = loginCredential;
		this.userProfile = userProfile;
	}

}
