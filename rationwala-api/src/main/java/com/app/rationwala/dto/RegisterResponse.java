package com.app.rationwala.dto;

import com.app.rationwala.model.UserProfile;

import lombok.Data;

public @Data class RegisterResponse {
	private UserProfile userProfile;
	private StatusInfo statusInfo;

	public RegisterResponse() {
	}

	public RegisterResponse(UserProfile userProfile) {
		super();
		this.userProfile = userProfile;
	}
}
