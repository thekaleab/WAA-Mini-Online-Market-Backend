package com.example.waaonlineminimarketbackend.entity.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInputDto {
    private String name;
    private String description;
    private String category;
    private double price;
    private int quantity;
    private String imgUrl;
}
