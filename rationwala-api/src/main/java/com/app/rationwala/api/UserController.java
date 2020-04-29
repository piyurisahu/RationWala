package com.app.rationwala.api;

import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.dto.LoginResponse;
import com.app.rationwala.model.LoginCredential;
import com.app.rationwala.service.UserService;

@RestController
@RequestMapping("user")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "Please go to user methods";
	}

	@PostMapping(value = "login", produces = "application/json")
	public LoginResponse login(@RequestBody LoginCredential loginCredential) {
		LoginRequest request = new LoginRequest(loginCredential);
		return userService.login(request);
	}

	@PostMapping(value = "register", produces = "application/json")
	public String register(@RequestBody RegisterRequest registerRequest) {
		String result = null;
		try {
			result = mapper.writeValueAsString(userService.register(registerRequest));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}