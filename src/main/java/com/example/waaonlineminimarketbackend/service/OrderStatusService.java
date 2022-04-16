package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Item;

import java.util.List;

public interface OrderStatusService {

    public void saveOrderStatus();
    public List<Item> getAllOrderStatus();
    public Item getOrderStatusById(long id);
    public void deleteOrderStatusById(long id);
    public void UpdateOrderStatusById(long id);
}
