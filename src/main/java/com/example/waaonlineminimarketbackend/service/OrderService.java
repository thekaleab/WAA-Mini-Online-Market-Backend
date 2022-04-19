package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderUpdateInputDto;

import java.util.List;

public interface OrderService {

     void saveOrder(OrderInputDto orderD) throws Exception;
     List<Order> getAllOrder();
     List<Order> getByBuyer(long id);
     Order getOrderById(long id);
     void deleteOrderById(long id);
     void UpdateOrderById(long id, OrderStatus orderD);
     void updateStatus(long id, OrderStatusInputDto orderStatusDto);
}
