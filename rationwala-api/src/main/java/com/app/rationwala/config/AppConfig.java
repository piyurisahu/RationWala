package com.app.rationwala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.rationwala.modeller.ItemModeller;
import com.app.rationwala.modeller.ProfileModeller;
import com.app.rationwala.service.AccountService;
import com.app.rationwala.service.AccountServiceImpl;
import com.app.rationwala.service.ItemService;
import com.app.rationwala.service.ItemServiceImpl;
import com.app.rationwala.service.OrderService;
import com.app.rationwala.service.OrderServiceImpl;
import com.app.rationwala.service.UserService;
import com.app.rationwala.service.UserServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public ItemService getItemService() {
		return new ItemServiceImpl();
	}
	
	@Bean
	public OrderService getOrderService() {
		return new OrderServiceImpl();
	}
	
	@Bean
	public UserService getUserService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public AccountService getAccountService() {
		return new AccountServiceImpl();
	}

	@Bean
	public ProfileModeller getProfileModeller() {
		return new ProfileModeller();
	}

	@Bean
	public ItemModeller getItemModeller() {
		return new ItemModeller();
	}
}
