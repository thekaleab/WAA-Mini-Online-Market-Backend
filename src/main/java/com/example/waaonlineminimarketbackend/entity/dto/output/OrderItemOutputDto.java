package com.example.waaonlineminimarketbackend.entity.dto.output;

import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemOutputDto {
        private long id;
        private int quantity;
        private ProductOutputDto product;
        private OrderStatus status;
        private LocalDateTime orderTime;
        private LocalDateTime updatedTime;
}
