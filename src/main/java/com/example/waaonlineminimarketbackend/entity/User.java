package com.example.waaonlineminimarketbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name="seller_id")
    List<Product> products;
}
