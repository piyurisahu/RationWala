package com.app.rationwala;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.rationwala.repository.ItemInventoryRepository;
import com.app.rationwala.repository.ItemRepository;
import com.app.rationwala.repository.StaffAuthRepository;
import com.app.rationwala.repository.UserProfileRepository;
import com.app.rationwala.util.MockDataInDB;

@SpringBootApplication
public class RationwalaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RationwalaApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserProfileRepository upr, StaffAuthRepository sar, ItemRepository ir,
			ItemInventoryRepository iir) {
		return (args) -> {
			MockDataInDB.pushUserData(upr);
			MockDataInDB.pushStaffAuthorization(sar);
			MockDataInDB.pushItem(ir);
			MockDataInDB.pushInventory(iir);
		};
	}
}
