package com.example.waaonlineminimarketbackend.entity.dto.input;
import com.example.waaonlineminimarketbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInputDto {
    private List<OrderItemInputDto> order;
}
