package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Item;
import com.example.waaonlineminimarketbackend.entity.Order;

import java.util.List;

public interface OrderService {

     void saveOrder(Order order);
     List<Order> getAllOrder();
     Order getOrderById(long id);
     void deleteOrderById(long id);
     void UpdateOrderById(long id, Order order);
}
