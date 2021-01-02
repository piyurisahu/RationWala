package com.app.rationwala.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.app.rationwala.dto.GetAllSellersRequest;
import com.app.rationwala.dto.GetAllSellersResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.modeller.ProfileModeller;
import com.app.rationwala.repository.UserProfileRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	Environment env;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private ProfileModeller profileModeller;


	@Override
	public GetAllSellersResponse getAllSellers(GetAllSellersRequest getAllSellersRequest) {
		GetAllSellersResponse res = new GetAllSellersResponse();
		res.setStatusInfo(new StatusInfo());
		try {
			List<UserProfile> sellerProfiles = userProfileRepository.findAllSellers();
			res.setSellerProfiles(new ArrayList<>());
			for (UserProfile seller : sellerProfiles) {
				res.getSellerProfiles().add(profileModeller.marshallUserProfile(seller));
			}
			res.getStatusInfo().setStatus(Status.SUCCESS);
		} catch (Exception e) {
			res.getStatusInfo().setStatus(Status.FAILURE);
		}
		return res;
	}

}
