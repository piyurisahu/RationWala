package com.app.rationwala.modeller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.app.rationwala.dto.enums.ItemCategoryType;
import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.dto.enums.StaffAuthType;
import com.app.rationwala.dto.enums.ItemPackageType;
import com.app.rationwala.entity.StaffAuth;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.model.Item;
import com.app.rationwala.model.ItemInventory;
import com.app.rationwala.model.LoginCredential;
import com.app.rationwala.model.Product;
import com.app.rationwala.model.UserProfile;

public class ProfileModeller extends AbstractModeller {
	public UserProfile marshallUserProfile(com.app.rationwala.entity.UserProfile userProfile) {
		com.app.rationwala.model.UserProfile result = null;
		if (isNotNull(userProfile)) {
			result = new com.app.rationwala.model.UserProfile();
			result.setUserProfileId(userProfile.getId());
			result.setFirstName(userProfile.getFirstName());
			result.setLastName(userProfile.getLastName());
			result.setEmail(userProfile.getEmail());
			result.setAddressLine1(userProfile.getAddressLine1());
			result.setAddressLine2(userProfile.getAddressLine2());
			result.setPhoneNumber(userProfile.getPhoneNumber());
			result.setZipcode(userProfile.getZipcode());
			result.setSellerProfile(userProfile.isSellerProfile());
			result.setSellerBusinessName(userProfile.getSellerBusinessName());
		}

		return result;
	}

	public LoginCredential marshall(UserLogin userLogin) {
		LoginCredential result = null;
		if (isNotNull(userLogin)) {
			result = new LoginCredential();
			result.setUsername(userLogin.getUsername());
			result.setPassword(userLogin.getPassword());
		}
		return result;
	}

	public Product marshall(com.app.rationwala.entity.Product product) {
		Product product1 = null;
		if (isNotNull(product)) {
			product1 = new Product();
			if (isNotNull(product.getId()))
				product1.setId(product.getId());
			if (isNotNull(product.getProductName()))
				product1.setProductName(product.getProductName());
			if (isNotNull(product.getProductDescription()))
				product1.setProductDescription(product.getProductDescription());
			if (isNotNull(product.getProductPrice()))
				product1.setProductPrice(product.getProductPrice());
			if (isNotNull(product.isAvailable()))
				product1.setAvailable(product.isAvailable());
		}

		return product1;
	}

	public List<ItemInventory> marshallItemInventory(Set<com.app.rationwala.entity.ItemInventory> itemInvent) {
		final List<ItemInventory> itemInventoryList;
		if (isNotNull(itemInvent) && !itemInvent.isEmpty()) {
			itemInventoryList = new ArrayList<>();
			itemInvent.forEach(itemInv -> {
				ItemInventory itemInventory = new ItemInventory();
				itemInventory.setDescription(itemInv.getDescription());
				itemInventory.setPrice(itemInv.getPrice());
				itemInventory.setQuantity(itemInv.getQuantity());
				itemInventory.setUnit(ItemUnitType.valueOf(itemInv.getUnit()));
				if (isNotNull(itemInv.getItem())) {
					itemInventory.setItem(new Item());
					itemInventory.getItem().setItemId(itemInv.getItem().getId());
					itemInventory.getItem().setItemBrand(itemInv.getItem().getItemBrand());
					itemInventory.getItem()
							.setItemCategory(ItemCategoryType.valueOf(itemInv.getItem().getItemCategory()));
					itemInventory.getItem().setItemName(itemInv.getItem().getItemName());
					itemInventory.getItem().setItemType(itemInv.getItem().getItemType());
					itemInventory.getItem().setPackageType(ItemPackageType.valueOf(itemInv.getItem().getPackageType()));
				}
				itemInventoryList.add(itemInventory);
			});
		} else {
			itemInventoryList = null;
		}
		return itemInventoryList;
	}

	public List<UserProfile> marshallStaffProfiles(Set<StaffAuth> staffSet) {
		final List<UserProfile> staffProfileList;
		if (isNotNull(staffSet) && !staffSet.isEmpty()) {
			staffProfileList = new ArrayList<>();
			staffSet.forEach(staffSetItem -> {
				UserProfile staffProfile = marshallUserProfile(staffSetItem.getStaffProfile());
				staffProfile.setStaffAuthType(StaffAuthType.valueOf(staffSetItem.getStaffAuthType()));
				staffProfileList.add(staffProfile);
			});
		} else {
			staffProfileList = null;
		}
		return staffProfileList;
	}

	public List<UserProfile> marshallSellerProfiles(Set<StaffAuth> sellerSet) {
		final List<UserProfile> sellerProfileList;
		if (isNotNull(sellerSet) && !sellerSet.isEmpty()) {
			sellerProfileList = new ArrayList<>();
			sellerSet.forEach(
					staffSetItem -> sellerProfileList.add(marshallUserProfile(staffSetItem.getSellerProfile())));
		} else {
			sellerProfileList = null;
		}
		return sellerProfileList;
	}
}
