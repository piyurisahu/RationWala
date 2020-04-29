package com.app.rationwala.repository;

import com.app.rationwala.entity.Product;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT a FROM Product a WHERE a.productName=:productName")
    public Product findByProductId(@Param("productName") String productName);

    @Query("SELECT a FROM Product a")
    public List<Product> listProducts();


}
