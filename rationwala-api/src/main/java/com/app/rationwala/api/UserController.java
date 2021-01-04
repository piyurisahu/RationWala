package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.dto.GetAllSellersRequest;
import com.app.rationwala.dto.GetAllSellersResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@Slf4j
@Api(tags = { "User API"}, value="UserController", description="This controller contains all APIs realted to users such as get all seller accounts.")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment env;

	@ApiOperation(value="This is health check for api")
	@GetMapping("/")
	public String index() {
		return "Please go to user methods";
	}

	@ApiOperation(value="Get All sellers")
	@PostMapping(value = "seller/all", produces = "application/json")
	public ResponseEntity<GetAllSellersResponse> getAllSellers(@RequestBody GetAllSellersRequest getAllSellersRequest) {
		ResponseEntity<GetAllSellersResponse> res = null;
		try {
			GetAllSellersResponse gres = userService.getAllSellers(null);
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(gres.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			res = new ResponseEntity<GetAllSellersResponse>(gres, status);
		} catch (Exception e) {
			res = new ResponseEntity<GetAllSellersResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
}