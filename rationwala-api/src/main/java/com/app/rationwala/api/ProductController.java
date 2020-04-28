package com.app.rationwala.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@RequestMapping("/product")
	public String index() {
		return "Please go to product methods";
	}
}
