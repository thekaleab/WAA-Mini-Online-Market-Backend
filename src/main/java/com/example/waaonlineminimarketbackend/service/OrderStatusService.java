package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Item;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;

import java.util.List;

public interface OrderStatusService {

     void saveOrderStatus(OrderStatus os);
     List<OrderStatus> getAllOrderStatus();
     OrderStatus getOrderStatusById(long id);
     void deleteOrderStatusById(long id);
     void UpdateOrderStatusById(long id, OrderStatus os);
}
