package com.example.waaonlineminimarketbackend.entity.dto.input;

import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusInputDto {
//    private long id;
    private OrderStatus status;
}
