package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.dto.LoginRequest;
import com.app.rationwala.dto.LoginResponse;
import com.app.rationwala.dto.RegisterRequest;
import com.app.rationwala.dto.RegisterResponse;
import com.app.rationwala.dto.enums.Status;
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
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		ResponseEntity<LoginResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(loginRequest));
			LoginResponse lres = userService.login(loginRequest);
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(lres.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			res = new ResponseEntity<LoginResponse>(userService.login(loginRequest), status);
		} catch (JsonProcessingException e) {
			res = new ResponseEntity<LoginResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}

	@PostMapping(value = "register", produces = "application/json")
	public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
		ResponseEntity<RegisterResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(registerRequest));
			res = new ResponseEntity<RegisterResponse>(userService.register(registerRequest), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			res = new ResponseEntity<RegisterResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
}