package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderUpdateInputDto;

import java.util.List;

public interface OrderService {

     void saveOrder(OrderInputDto orderD);
     List<Order> getAllOrder();
     Order getOrderById(long id);
     void deleteOrderById(long id);
     void UpdateOrderById(long id, OrderStatus orderD);
}
