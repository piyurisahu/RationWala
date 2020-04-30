package com.app.rationwala;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.rationwala.repository.UserLoginRepository;
import com.app.rationwala.repository.UserProfileRepository;
import com.app.rationwala.util.MockDataInDB;

@SpringBootApplication
public class RationwalaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RationwalaApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserLoginRepository userLoginRepository,
			UserProfileRepository userProfileRepository) {
		return (args) -> {
			MockDataInDB.pushUserData(userLoginRepository, userProfileRepository);
		};
	}
}
