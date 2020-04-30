package com.app.rationwala.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.rationwala.entity.BusinessAuth;

@Repository
public interface BusinessAuthRepository extends CrudRepository<BusinessAuth, Long> {

}
