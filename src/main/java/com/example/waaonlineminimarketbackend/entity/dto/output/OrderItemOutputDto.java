package com.example.waaonlineminimarketbackend.entity.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemOutputDto {
        private int quantity;
        private ProductOutputDto product;
}
