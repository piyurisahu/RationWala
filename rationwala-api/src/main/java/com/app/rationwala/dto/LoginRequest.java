package com.app.rationwala.dto;

import com.app.rationwala.model.LoginCredential;

import lombok.Data;

public @Data class LoginRequest {

	private LoginCredential loginCredential;

	public LoginRequest() {
	}

	public LoginRequest(LoginCredential loginCredential) {
		super();
		this.loginCredential = loginCredential;
	}

}
