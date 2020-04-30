package com.app.rationwala.util;

import java.util.stream.IntStream;

import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.repository.UserLoginRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class MockDataInDB {

	public static void pushUserData(UserLoginRepository userLoginRepository,
			UserProfileRepository userProfileRepository) {
		IntStream.range(1, 11)
				.forEach(userId -> userProfileRepository.save(new UserProfile(new UserLogin("user" + userId, "admin"),
						"Firstname" + userId, "Lastname", "user" + userId + "@abc.com", "123456789",
						"user" + userId + "add1", "user" + userId + "add2", "12345")));

		IntStream.range(1, 11).forEach(userId -> userProfileRepository
				.save(new UserProfile(new UserLogin("busUser" + userId, "admin"), "BusFirstname" + userId,
						"BusLastname", "Bususer" + userId + "@abc.com", "123456789", "Bususer" + userId + "add1",
						"Bususer" + userId + "add2", "12345", true, "Shop no: " + userId)));
	}
}
