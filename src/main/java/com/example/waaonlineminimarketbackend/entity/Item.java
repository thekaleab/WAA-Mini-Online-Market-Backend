package com.example.waaonlineminimarketbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String name;
    private double price;
    private int quantity;

    @OneToMany()
    @JoinColumn(name = "item_id")
    private List<Review> reviewList;
}
