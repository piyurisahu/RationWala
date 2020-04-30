package com.app.rationwala;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.rationwala.repository.StaffAuthRepository;
import com.app.rationwala.repository.UserProfileRepository;
import com.app.rationwala.util.MockDataInDB;

@SpringBootApplication
public class RationwalaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RationwalaApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserProfileRepository userProfileRepository,
			StaffAuthRepository staffAuthRepository) {
		return (args) -> {
			MockDataInDB.pushUserData(userProfileRepository);
			MockDataInDB.pushStaffAuthorization(staffAuthRepository);
		};
	}
}
