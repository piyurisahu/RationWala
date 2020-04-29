package com.app.rationwala.entity;

import javax.persistence.*;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = {CascadeType.ALL})
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

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return String.format(
				"UserProfile[userId=%d, firstName='%s', lastName='%s', email='%s', phoneNumber='%s', addressLine1='%s', addressLine2='%s', zipcode='%s']",
				userLogin.getId(), firstName, lastName, email, phoneNumber, addressLine1, addressLine2, zipcode);
	}
}
