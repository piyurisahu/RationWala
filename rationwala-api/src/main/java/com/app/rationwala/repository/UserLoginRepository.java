package com.app.rationwala.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.rationwala.entity.UserLogin;

@Repository
public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {

	@Query("SELECT a FROM UserLogin a WHERE a.username=:username and a.password=:password")
	public UserLogin findByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
