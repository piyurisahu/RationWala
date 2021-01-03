package com.app.rationwala;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
			MockDataInDB.pushItem(ir, iir);
//			MockDataInDB.pushInventory(iir);
		};
	}
	
	@Configuration
	@EnableWebMvc
	public class SpringConfig implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	    }
	}
}
