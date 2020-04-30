package com.app.rationwala.util;

import java.util.stream.IntStream;

import com.app.rationwala.dto.enums.StaffAuthType;
import com.app.rationwala.entity.StaffAuth;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.repository.StaffAuthRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class MockDataInDB {

	public static void pushUserData(UserProfileRepository userProfileRepository) {
		// User profiles
		IntStream.range(1, 11)
				.forEach(userId -> userProfileRepository.save(new UserProfile(new UserLogin("user" + userId, "admin"),
						"Firstname" + userId, "Lastname", "user" + userId + "@abc.com", "123456789",
						"user" + userId + "add1", "user" + userId + "add2", "12345")));

		// BusUser profiles
		IntStream.range(1, 11).forEach(userId -> userProfileRepository
				.save(new UserProfile(new UserLogin("busUser" + userId, "admin"), "BusFirstname" + userId,
						"BusLastname", "Bususer" + userId + "@abc.com", "123456789", "Bususer" + userId + "add1",
						"Bususer" + userId + "add2", "12345", true, "Shop no: " + userId)));

		// Staff profiles
		IntStream.range(1, 11).forEach(
				userId -> userProfileRepository.save(new UserProfile(new UserLogin("staffUser" + userId, "admin"),
						"staffFirstname" + userId, "staffLastname", "staffUser" + userId + "@abc.com", "123456789",
						"staffUser" + userId + "add1", "staffUser" + userId + "add2", "12345")));

	}

	public static void pushStaffAuthorization(StaffAuthRepository staffAuthRepository) {
		staffAuthRepository.save(new StaffAuth(new UserProfile(11L), new UserProfile(21L), StaffAuthType.INVENTORY.name()));

	}
}
