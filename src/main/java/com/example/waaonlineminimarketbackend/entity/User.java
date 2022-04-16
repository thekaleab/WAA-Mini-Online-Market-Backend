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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;

    @ManyToMany
    private List<Role> roleList;

    @OneToOne()
    private Address address;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Order> orderList;

}
