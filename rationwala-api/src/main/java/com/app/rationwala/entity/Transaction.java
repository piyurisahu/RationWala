package com.app.rationwala.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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
