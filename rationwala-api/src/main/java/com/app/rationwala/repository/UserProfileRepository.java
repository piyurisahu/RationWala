package com.app.rationwala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

	@Query("SELECT a FROM UserProfile a WHERE a.userLogin=:userLogin")
	public UserProfile findByUserId(@Param("userLogin") UserLogin userLogin);
	
	@Query("SELECT a FROM UserProfile a WHERE a.sellerProfile = TRUE")
	public List<UserProfile> findAllSellers();
}
