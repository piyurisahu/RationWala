package com.app.rationwala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.rationwala.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {

	@Query("SELECT a FROM PurchaseOrder a WHERE a.buyerProfile.id=:userId")
	public List<PurchaseOrder> findByBuyerId(@Param("userId") Long userId);

}
