package com.example.waaonlineminimarketbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull

    private String name;

//    @Column(nullable = false)
//    @NotNull

    @Column(columnDefinition="TEXT")
    private String description;

    private String category;

//    @NotNull
    private double price;
    private int quantity;
    private String imgUrl;

    @ManyToOne
    @JsonIgnore
    private User seller;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<Review> reviews;
}
