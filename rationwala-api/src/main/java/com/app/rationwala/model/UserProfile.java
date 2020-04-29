package com.app.rationwala.model;

import lombok.Data;

public @Data class UserProfile {
	private ProfilePicture profilePicture;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String zipcode;

	public UserProfile() {
	}

	public UserProfile(ProfilePicture profilePicture, String firstName, String lastName, String email,
			String phoneNumber, String addressLine1, String addressLine2, String zipcode) {
		super();
		this.profilePicture = profilePicture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipcode = zipcode;
	}

}
