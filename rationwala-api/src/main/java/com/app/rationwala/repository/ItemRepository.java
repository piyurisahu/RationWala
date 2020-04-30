package com.app.rationwala.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.rationwala.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
