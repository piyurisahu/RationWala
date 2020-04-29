package com.app.rationwala.api;

import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.model.LoginCredential;
import com.app.rationwala.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "Please go to user methods";
	}

	@GetMapping(value = "login/{username}/{password}", produces = "application/json")
	public String login(@PathVariable String username, @PathVariable String password) {
		LoginRequest request = new LoginRequest(new LoginCredential(username, password));
		String result = null;
		;
		try {
			result = mapper.writeValueAsString(userService.login(request).getUserProfile());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
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