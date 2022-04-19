package com.example.waaonlineminimarketbackend.entity.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOutputDto {
    private long id;
    private String name;
    private String description;
    private String category;
    private double price;
    private int quantity;
    private String imgUrl;
}
