package com.app.rationwala.dto;

import com.app.rationwala.model.LoginCredential;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.model.UserProfile;

import lombok.Data;

public @Data class LoginResponse {
	private LoginCredential loginCredential;
	private UserProfile userProfile;
	private StatusInfo statusInfo;

	public LoginResponse() {
	}

	public LoginResponse(LoginCredential loginCredential, UserProfile userProfile) {
		super();
		this.loginCredential = loginCredential;
		this.userProfile = userProfile;
	}

}
