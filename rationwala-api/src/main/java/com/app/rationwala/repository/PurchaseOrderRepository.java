package com.app.rationwala.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.rationwala.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {

}
