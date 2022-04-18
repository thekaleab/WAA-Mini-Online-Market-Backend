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
public class Item {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull

    private String name;

//    @Column(nullable = false)
//    @NotNull

    private String description;

//    @NotNull
    private double price;

    private boolean isAvailable = true;
    @ManyToOne
    @JsonIgnore
    private Seller seller;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    private List<Review> reviews;
}
