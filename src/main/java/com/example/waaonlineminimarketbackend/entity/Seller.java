package com.example.waaonlineminimarketbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstname;


    private String lastname;


    private String email;


    private String password;

    private boolean approved = false;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "buyer_seller_follow")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude

    private Set<Buyer> followers = new HashSet<>();
    @OneToMany(mappedBy = "seller")
    private List<Item> itemList;
}
