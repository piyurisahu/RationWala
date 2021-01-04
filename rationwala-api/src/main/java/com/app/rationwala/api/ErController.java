package com.app.rationwala.api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="ErController", description="This controller contains all APIs realted to error handeling.")
public class ErController implements ErrorController {
	private static final String PATH = "/error";

	@GetMapping(value = PATH)
	public String error() {
		return "Some Error Occured";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
