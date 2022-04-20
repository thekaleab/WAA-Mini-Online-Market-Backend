package com.example.waaonlineminimarketbackend.entity.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemStatusInputDto {
    private long orderId;
    private long statusId;
}
