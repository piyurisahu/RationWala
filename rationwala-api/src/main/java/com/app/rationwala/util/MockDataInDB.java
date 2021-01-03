package com.app.rationwala.util;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.app.rationwala.dto.enums.ItemCategoryType;
import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.dto.enums.StaffAuthType;
import com.app.rationwala.dto.enums.ItemPackageType;
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
		repo.save(new UserProfile(new UserLogin("Seller1", "admin"), "Tarun",
				"Gupta", "tarung@abc.com" , "9494942354", "XYZ Gomti Nagar",
				"Lucknow", "12345", true, "Gupta General Store"));

		repo.save(new UserProfile(new UserLogin("Seller2", "admin"), "Kiran",
				"Arora", "kirana@abc.com" , "9494987654", "5/7 Vinay Khand",
				"Lucknow", "12365", true, "Arora Departmental Store"));

		repo.save(new UserProfile(new UserLogin("Seller3", "admin"), "Vikas",
				"Malik", "vikasM@abc.com" , "9484987654", "55 Shaheed ChandraShekhar Chowk",
				"Gomti Nagar, Lucknow", "226010", true, "Mr brown Ration Mall"));


		repo.save(new UserProfile(new UserLogin("Seller4", "admin"), "Tanushree",
				"Gupta", "TanuSh@abc.com" , "9484987772", "67/5 Indira Nagar ",
				"Sector 14, Lucknow", "226011", true, "1 Stop Grocery"));


		repo.save(new UserProfile(new UserLogin("Seller5", "admin"), "Sonu",
				"Khan", "SonuK@abc.com" , "9484828200", "Shop no 123, metro Plaza",
				"Metro station, Lucknow", "226016", true, "EveryDay Mart "));


		repo.save(new UserProfile(new UserLogin("Seller6", "admin"), "Rakesh",
				"Yadav", "rakeshY@abc.com" , "9484828772", "C-1/2, Sahara State Road",
				"Sector G, Lucknow", "226021", true, "GrocerSpace "));


		repo.save(new UserProfile(new UserLogin("Seller7", "admin"), "Raman",
				"Sahu", "ramanS@abc.com" , "9484833772", "6/9, Nayak Nagar",
				"Sitapur Road, Lucknow", "226021", true, "Day to Day mart"));


		repo.save(new UserProfile(new UserLogin("Seller8", "admin"), "Kapil",
				"Mishra", "kapilM@abc.com" , "9484833000", "Ring Road, Near Cocacola Goadam",
				"Vikas Nagar, Lucknow", "226022", true, "Family Bazar"));



		repo.save(new UserProfile(new UserLogin("Seller9", "admin"), "Anjali",
				"Tripathi", "anjaliT@abc.com" , "94849468730", "3/48, Mansarovar Yojna",
				"Jalvayu Vihar Phase 2, Lucknow", "226010", true, "All Season Fresh Mart"));



		repo.save(new UserProfile(new UserLogin("Seller10", "admin"), "Lucky",
				"Sachdeva", "luckyS@abc.com" , "94849473777", "HG-94, LDA Colony",
				"Kanpur Road, Lucknow", "226012", true, "Sachdeva Store"));

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

		repo.save(new Item("Coconut Oil", "O'range",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Water Bottle", "Bislery",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Coconut Oil", "O'range",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Chakki Atta", "Ashirvaad",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Salt", "Tata",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Mustard Oil", "Fortune",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Hinge", "Catch Compounded",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Moong Dal", "Family Farm",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Pure Ghee", "Amul",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Munch", "Nestle",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Basmati Rice", "Kohinoor Royal",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Maggi Masala Magic", "Maggi",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Chyawanprash", "Dabur",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Rajma", "Chithra",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Magic Masala", "Sunfeast",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Green chilly Chutney", "Pravin",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));
		repo.save(new Item("Green Chilly Chutney", "Food Art Factory",
				ItemCategoryType.EATABLE.name(), ItemPackageType.BRAND_PACKAGED.name(), "ItemType"));

	}

	public static void pushInventory(ItemInventoryRepository repo) {
		LongStream.range(1, 11).forEach(i -> {
			IntStream.range(1, 11)
					.forEach(j -> repo.save(new ItemInventory(new UserProfile(i), new Item(Long.parseLong(j + "")),
							"Item seller description", Double.parseDouble(i + ""), j, j, ItemUnitType.COUNT.name())));
		});
	}
}
