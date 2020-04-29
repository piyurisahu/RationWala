package com.app.rationwala.config;

import com.app.rationwala.service.ProductService;
import com.app.rationwala.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.rationwala.service.UserService;
import com.app.rationwala.service.UserServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public UserService getUserService() {
		return new UserServiceImpl();
	}

	@Bean
	public ProductService getProductService() {
		return new ProductServiceImpl();
	}
}
