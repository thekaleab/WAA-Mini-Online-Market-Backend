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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int Coupon =0;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany
    @JoinColumn(name="user_id")
    List<Address> addresses;

    @OneToOne
    private Role role;

    private Boolean isSellerApproved;

    @OneToMany
    @JoinColumn(name="buyer_id")
    List<Order> orders;

    @OneToMany(mappedBy = "seller")
    List<Product> products;

    @ManyToMany()
    Set<User> buyerFollowerList = new HashSet<>();
}
