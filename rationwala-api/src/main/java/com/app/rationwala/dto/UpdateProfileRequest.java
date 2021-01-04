package com.app.rationwala.dto;

import com.app.rationwala.model.UserProfile;

import lombok.Data;

public @Data class UpdateProfileRequest {
	private UserProfile userProfile;
}
