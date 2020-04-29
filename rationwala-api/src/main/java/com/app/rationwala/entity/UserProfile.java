package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
public @Data class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private UserLogin userLogin;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String zipcode;

	public UserProfile() {
	}

	public UserProfile(UserLogin userLogin, String firstName, String lastName, String email, String phoneNumber,
			String addressLine1, String addressLine2, String zipcode) {
		super();
		this.userLogin = userLogin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipcode = zipcode;
	}
}
