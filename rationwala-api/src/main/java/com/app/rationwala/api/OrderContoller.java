package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderContoller extends AbstractController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String index() {
		return "Please go to order methods";
	}
}