package com.app.rationwala.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.rationwala.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
