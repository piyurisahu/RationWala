package com.app.rationwala.dto;

import java.util.Set;

import com.app.rationwala.model.StaffAuthorization;

import lombok.Data;

public @Data class AuthorizeStaffRequest {
	private Long sellerUserProfileId;
	private Set<StaffAuthorization> staffAuthorization;
}
