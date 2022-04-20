package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderItemStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderItemOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;

import java.util.List;

public interface OrderService {

     void saveOrder(OrderInputDto orderD) throws Exception;
     List<OrderOutputDto> getAllOrder();
     List<OrderOutputDto> getByBuyer(long id);
     Order getOrderById(long id);
     void deleteOrderById(long id);
     void UpdateOrderById(long id, OrderStatus orderD);
     void updateStatus(long id, OrderStatusInputDto statusInputDto) throws BadRequestException;
     void updateOrderItemStatus(long id, OrderItemStatusInputDto orderItemStatusInputDto) throws BadRequestException;
     List<OrderStatus> getAllOrderStatus();

    List<OrderOutputDto> getAllOrdersBySeller(long id);

    // OrderItem related, added here because orderItem and Order are closely coupled
    List<OrderItemOutputDto> getAllOrderItemsBySeller(long id);
}
