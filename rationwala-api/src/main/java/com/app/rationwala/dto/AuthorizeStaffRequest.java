package com.app.rationwala.dto;

import java.util.Set;

import lombok.Data;

public @Data class AuthorizeStaffRequest {
	private Long businessUserProfileId;
	private Set<StaffAuthorization> staffAuthorization;
}
