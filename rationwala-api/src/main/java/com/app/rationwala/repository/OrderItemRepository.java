package com.app.rationwala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.rationwala.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

	@Query("SELECT a FROM OrderItem a WHERE a.purchaseOrder.id=:purchaseOrderId")
	public List<OrderItem> findByPurchaseOrder(@Param("purchaseOrderId") Long purchaseOrderId);

}
