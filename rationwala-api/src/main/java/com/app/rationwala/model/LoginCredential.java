package com.app.rationwala.model;

import lombok.Data;

public @Data class LoginCredential {

	private String username;
	private String password;

	public LoginCredential() {
	}

	public LoginCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
