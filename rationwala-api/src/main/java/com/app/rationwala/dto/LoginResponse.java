package com.app.rationwala.dto;

import java.util.List;

import com.app.rationwala.model.ItemInventory;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.model.UserProfile;

import lombok.Data;

public @Data class LoginResponse {
	private String token;
	private UserProfile userProfile;
	private List<ItemInventory> itemInventoryList;
	private List<UserProfile> staffProfiles;
	private List<UserProfile> sellerProfiles;
	private StatusInfo statusInfo;

	public LoginResponse() {
	}

}
