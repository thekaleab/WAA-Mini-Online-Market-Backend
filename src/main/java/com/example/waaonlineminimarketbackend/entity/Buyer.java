package com.example.waaonlineminimarketbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Buyer {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private final String role = "BUYER";

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "followers")
//    private Set<Seller> followingSellers = new HashSet<>();

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "buyer_id")
//    @Fetch(FetchMode.JOIN)
//    private List<Address> addresses;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private ShoppingCart shoppingCart;

    private Integer points;
    @OneToMany
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<Review> reviews;
}
