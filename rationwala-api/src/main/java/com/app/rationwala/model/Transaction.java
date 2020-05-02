package com.app.rationwala.model;

import com.app.rationwala.entity.Product;
import com.app.rationwala.entity.UserProfile;
import lombok.Data;

import javax.persistence.*;

public @Data class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER )
    private UserProfile userProfile;

    @ManyToOne(fetch = FetchType.EAGER )
    private Product product;

    private int quantity;

}
