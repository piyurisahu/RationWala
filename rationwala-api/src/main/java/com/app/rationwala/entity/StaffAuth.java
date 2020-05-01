package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter @Entity class StaffAuth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserProfile sellerProfile;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserProfile staffProfile;

	@NotNull
	private String staffAuthType;

	public StaffAuth() {
	}

	public StaffAuth(UserProfile sellerProfile, UserProfile staffProfile, String staffAuthType) {
		super();
		this.sellerProfile = sellerProfile;
		this.staffProfile = staffProfile;
		this.staffAuthType = staffAuthType;
	}

}
