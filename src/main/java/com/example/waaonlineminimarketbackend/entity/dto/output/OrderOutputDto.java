package com.example.waaonlineminimarketbackend.entity.dto.output;

import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderOutputDto {
    private Long id;
    private double amount;
    List<OrderItemOutputDto> orderItems;
    private OrderStatus status;
    private UserOutputDto buyer;
    private LocalDateTime orderTime;
    private LocalDateTime updatedTime;
}
