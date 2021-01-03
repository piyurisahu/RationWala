package com.app.rationwala.modeller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.app.rationwala.dto.enums.StaffAuthType;
import com.app.rationwala.entity.StaffAuth;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.model.LoginCredential;
import com.app.rationwala.model.ProfilePicture;
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
			result.setProfilePicture(new ProfilePicture());
			result.getProfilePicture().setSellerLogoUrl(userProfile.getSellerLogoUrl());
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
