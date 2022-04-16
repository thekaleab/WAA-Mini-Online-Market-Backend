package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Item;
import com.example.waaonlineminimarketbackend.entity.Order;

import java.util.List;

public interface OrderService {

    public void saveOrder(Order order);
    public List<Order> getAllOrder();
    public Order getOrderById(long id);
    public void deleteOrderById(long id);
    public void UpdateOrderById(long id, Order order);
}
