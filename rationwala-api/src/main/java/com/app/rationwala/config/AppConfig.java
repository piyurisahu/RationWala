package com.app.rationwala.config;

import com.app.rationwala.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

	@Bean
	public TransactionService getTransactionService() {
		return new TransactionServiceImpl();
	}
}
