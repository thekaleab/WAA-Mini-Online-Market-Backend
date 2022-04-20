package com.example.waaonlineminimarketbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @Column(nullable = false)
    @NotBlank
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    private String lastName;

    private int Coupon =0;


    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Size(min=4)
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
