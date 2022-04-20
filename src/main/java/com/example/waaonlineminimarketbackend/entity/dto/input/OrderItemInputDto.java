package com.example.waaonlineminimarketbackend.entity.dto.input;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderItemInputDto {
    private long productId;
    private int quantity;
}
