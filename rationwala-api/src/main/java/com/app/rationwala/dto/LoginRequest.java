package com.app.rationwala.dto;

import com.app.rationwala.model.LoginCredential;

public class LoginRequest {

	private LoginCredential loginCredential;

	public LoginRequest() {
	}

	public LoginRequest(LoginCredential loginCredential) {
		super();
		this.loginCredential = loginCredential;
	}

	public LoginCredential getLoginCredential() {
		return loginCredential;
	}

	public void setLoginCredential(LoginCredential loginCredential) {
		this.loginCredential = loginCredential;
	}

}
