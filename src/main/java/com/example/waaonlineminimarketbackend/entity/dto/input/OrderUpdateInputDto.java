package com.example.waaonlineminimarketbackend.entity.dto.input;

import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateInputDto {
    private OrderStatus orderStatus;
}
