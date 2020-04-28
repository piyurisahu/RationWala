package com.app.rationwala.dto;

import com.app.rationwala.model.UserProfile;

public class RegisterResponse {
	private UserProfile userProfile;

	public RegisterResponse() {
	}

	public RegisterResponse(UserProfile userProfile) {
		super();
		this.userProfile = userProfile;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
