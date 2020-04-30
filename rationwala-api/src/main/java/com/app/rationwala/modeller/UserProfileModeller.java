package com.app.rationwala.modeller;

import com.app.rationwala.model.Product;

public class UserProfileModeller extends AbstractModeller {
	public com.app.rationwala.model.UserProfile marshall(com.app.rationwala.entity.UserProfile userProfile) {
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

	public com.app.rationwala.model.LoginCredential marshall(com.app.rationwala.entity.UserLogin userLogin) {
		com.app.rationwala.model.LoginCredential result = null;
		if (isNotNull(userLogin)) {
			result = new com.app.rationwala.model.LoginCredential();
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
		}

		return product1;
	}
}
