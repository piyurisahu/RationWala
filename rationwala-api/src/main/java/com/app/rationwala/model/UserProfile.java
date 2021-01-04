package com.app.rationwala.model;

import com.app.rationwala.dto.enums.StaffAuthType;

import lombok.Data;

public @Data class UserProfile {
	private ProfilePicture profilePicture;
	private Long userProfileId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipcode;
	private boolean sellerProfile;
	private String sellerBusinessName;
	private StaffAuthType staffAuthType;
	private Long userLoginId;
}
