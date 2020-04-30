package com.app.rationwala.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

public @Entity @Data class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private UserLogin userLogin;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String zipcode;
	private boolean businessProfile;
	private String businessName;

	@OneToMany(mappedBy = "businessProfile")
	private Set<BusinessAuth> staff;

	@OneToMany(mappedBy = "staff")
	private Set<BusinessAuth> businesses;

	public UserProfile(UserLogin userLogin, String firstName, String lastName, String email, String phoneNumber,
			String addressLine1, String addressLine2, String zipcode, boolean businessProfile, String businessName) {
		super();
		this.userLogin = userLogin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipcode = zipcode;
		this.businessProfile = businessProfile;
		this.businessName = businessName;
	}

	public UserProfile(UserLogin userLogin, String firstName, String lastName, String email, String phoneNumber,
			String addressLine1, String addressLine2, String zipcode) {
		this(userLogin, firstName, lastName, email, phoneNumber, addressLine1, addressLine2, zipcode, false, null);
	}

}
