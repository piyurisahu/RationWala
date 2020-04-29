package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.dto.LoginResponse;
import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;
import com.app.rationwala.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String index() {
		return "Please go to user methods";
	}

	@PostMapping(value = "login", produces = "application/json")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		System.out.println(env.getProperty("warn.exception.occurred"));
		try {
			log.debug(mapper.writeValueAsString(loginRequest));
		} catch (JsonProcessingException e) {
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return userService.login(loginRequest);
	}

	@PostMapping(value = "register", produces = "application/json")
	public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
		try {
			log.debug(mapper.writeValueAsString(registerRequest));
		} catch (JsonProcessingException e) {
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return userService.register(registerRequest);
	}
}