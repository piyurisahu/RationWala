package com.app.rationwala.model;

import com.app.rationwala.dto.enums.StaffAuthType;

import lombok.Data;

public @Data class StaffAuthorization {
	private Long staffUserProfileId;
	private StaffAuthType staffAuthType;
}
