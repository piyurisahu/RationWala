package com.app.rationwala.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.rationwala.entity.Item;

public interface ItemInventoryRepository extends CrudRepository<Item, Long> {

}
