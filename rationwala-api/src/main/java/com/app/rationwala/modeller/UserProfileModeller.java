package com.app.rationwala.modeller;

import com.app.rationwala.model.Product;

public class UserProfileModeller extends AbstractModeller {
	public com.app.rationwala.model.UserProfile marshall(com.app.rationwala.entity.UserProfile userProfile) {
		com.app.rationwala.model.UserProfile result = null;
		if (isNotNull(userProfile)) {
			result = new com.app.rationwala.model.UserProfile();
			if (isNotNull(userProfile.getId()))
				result.setUserProfileId(userProfile.getId());
			if (isNotNull(userProfile.getFirstName()))
				result.setFirstName(userProfile.getFirstName());
			if (isNotNull(userProfile.getLastName()))
				result.setLastName(userProfile.getLastName());
			if (isNotNull(userProfile.getEmail()))
				result.setEmail(userProfile.getEmail());
			if (isNotNull(userProfile.getAddressLine1()))
				result.setAddressLine1(userProfile.getAddressLine1());
			if (isNotNull(userProfile.getAddressLine2()))
				result.setAddressLine2(userProfile.getAddressLine2());
			if (isNotNull(userProfile.getPhoneNumber()))
				result.setPhoneNumber(userProfile.getPhoneNumber());
			if (isNotNull(userProfile.getZipcode()))
				result.setZipcode(userProfile.getZipcode());
		}

		return result;
	}

	public com.app.rationwala.model.LoginCredential marshall(com.app.rationwala.entity.UserLogin userLogin) {
		com.app.rationwala.model.LoginCredential result = null;
		if (isNotNull(userLogin)) {
			result = new com.app.rationwala.model.LoginCredential();
			if (isNotNull(userLogin.getUsername()))
				result.setUsername(userLogin.getUsername());
			if (isNotNull(userLogin.getPassword()))
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
