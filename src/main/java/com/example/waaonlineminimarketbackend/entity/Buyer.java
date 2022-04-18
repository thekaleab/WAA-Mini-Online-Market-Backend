package com.example.waaonlineminimarketbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Buyer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    private String firstname;

//    @Column(nullable = false)

    private String lastname;

//    @Column(unique = true, nullable = false)

    private String email;

//    @Column(nullable = false)

    private String password;

    @OneToMany
    private List<Address> address;

//    @JsonIgnore
////    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "followers")
//    private Set<Seller> followingSellers = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "buyer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    @OneToMany()
    List<Order> orderList;

    private Integer points;

}
