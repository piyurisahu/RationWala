package com.app.rationwala.repository;

import com.app.rationwala.entity.Product;
import com.app.rationwala.entity.Transaction;
import com.app.rationwala.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("SELECT a FROM Transaction a WHERE a.id=:id")
    public Transaction findByTranId(@Param("id") String id);

    @Query("SELECT a FROM Transaction a WHERE a.userProfile=:userProfile and a.product.available = true")
    public List<Transaction> getTransactionForUser(@Param("userProfile") UserProfile userProfile);

}
