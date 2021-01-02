package com.app.rationwala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.rationwala.entity.ItemInventory;

public interface ItemInventoryRepository extends CrudRepository<ItemInventory, Long> {

	@Query("SELECT a FROM ItemInventory a WHERE a.sellerProfile.id = :sellerProfileId")
	public List<ItemInventory> getInventoryBySellerId(@Param("sellerProfileId") Long sellerProfileId);
	
}
