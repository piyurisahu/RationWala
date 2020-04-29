package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}