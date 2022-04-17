package com.example.waaonlineminimarketbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstname;


    private String lastname;

    private String email; // somebody@email.com


    private String password;

    private boolean approved = false;

    @Transient
    private String role = "SELLER";

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "buyer_seller_follow")
//    private Set<Buyer> followers = new HashSet<>();
}
