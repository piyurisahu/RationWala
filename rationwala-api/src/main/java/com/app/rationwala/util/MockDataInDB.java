package com.app.rationwala.util;

import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.repository.UserLoginRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class MockDataInDB {

	public static void pushUserData(UserLoginRepository userLoginRepository,
			UserProfileRepository userProfileRepository) {
		userProfileRepository.save(new UserProfile(new UserLogin("anusha", "admin"), "Anusha", "Gupta",
				"anusha@abc.com", "123456789", "add1", "add2", "12345"));
		userProfileRepository.save(new UserProfile(new UserLogin("adi", "admin"), "Aditya", "Gupta", "adi@abc.com",
				"123456789", "add1", "add2", "12345"));
		userProfileRepository.save(new UserProfile(new UserLogin("suri", "admin"), "SuriVer", "Rag", "suri@abc.com",
				"123456789", "add1", "add2", "12345"));
		userProfileRepository.save(new UserProfile(new UserLogin("tg", "admin"), "Tarun", "Gupta", "tg@abc.com",
				"123456789", "add1", "add2", "12345"));
	}
}
