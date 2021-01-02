package com.app.rationwala.service;

import org.springframework.stereotype.Service;

import com.app.rationwala.dto.AuthorizeStaffRequest;
import com.app.rationwala.dto.AuthorizeStaffResponse;
import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.dto.LoginResponse;
import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;

@Service
public interface AccountService {
	public LoginResponse login(LoginRequest request);

	public RegisterResponse register(RegisterRequest registerRequest);

	public AuthorizeStaffResponse authorizeStaff(AuthorizeStaffRequest authorizeUserRequest);

}
