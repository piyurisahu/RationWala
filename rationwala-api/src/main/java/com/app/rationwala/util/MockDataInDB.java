package com.app.rationwala.util;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.app.rationwala.dto.enums.ItemCategoryType;
import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.dto.enums.StaffAuthType;
import com.app.rationwala.dto.enums.itemPackageType;
import com.app.rationwala.entity.Item;
import com.app.rationwala.entity.ItemInventory;
import com.app.rationwala.entity.StaffAuth;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.repository.ItemInventoryRepository;
import com.app.rationwala.repository.ItemRepository;
import com.app.rationwala.repository.StaffAuthRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class MockDataInDB {

	public static void pushUserData(UserProfileRepository repo) {
		// Seller profiles
		IntStream.range(1, 11)
				.forEach(i -> repo.save(new UserProfile(new UserLogin("Seller" + i, "admin"), "SellerFirstname" + i,
						"SellerLastname", "seller" + i + "@abc.com", "123456789", "Seller" + i + "add1",
						"Seller" + i + "add2", "12345", true, "Shop no: " + i)));

		// User profiles
		IntStream.range(1, 11)
				.forEach(userId -> repo.save(new UserProfile(new UserLogin("user" + userId, "admin"),
						"Firstname" + userId, "Lastname", "user" + userId + "@abc.com", "123456789",
						"user" + userId + "add1", "user" + userId + "add2", "12345")));

		// Staff profiles
		IntStream.range(1, 11)
				.forEach(userId -> repo.save(new UserProfile(new UserLogin("staffUser" + userId, "admin"),
						"staffFirstname" + userId, "staffLastname", "staffUser" + userId + "@abc.com", "123456789",
						"staffUser" + userId + "add1", "staffUser" + userId + "add2", "12345")));

	}

	public static void pushStaffAuthorization(StaffAuthRepository staffAuthRepository) {
		staffAuthRepository
				.save(new StaffAuth(new UserProfile(1L), new UserProfile(21L), StaffAuthType.INVENTORY.name()));
	}

	public static void pushItem(ItemRepository repo) {
		IntStream.range(1, 11).forEach(i -> repo.save(new Item("Itemname" + i, "ItemBrand" + i,
				ItemCategoryType.EATABLE.name(), itemPackageType.BRAND_PACKAGED.name(), "ItemType" + i)));
	}

	public static void pushInventory(ItemInventoryRepository repo) {
		LongStream.range(1, 11).forEach(i -> {
			IntStream.range(1, 11).forEach(j -> repo.save(new ItemInventory(new UserProfile(i), new Item(i),
					"Item seller description", Double.parseDouble(i + ""), j, ItemUnitType.COUNT.name())));
		});
	}
}
