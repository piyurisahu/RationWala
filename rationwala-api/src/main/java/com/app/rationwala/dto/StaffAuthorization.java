package com.app.rationwala.dto;

import com.app.rationwala.dto.enums.StaffAuthType;

import lombok.Data;

public @Data class StaffAuthorization {
	private Long staffUserProfileId;
	private StaffAuthType staffAuthType;
}
