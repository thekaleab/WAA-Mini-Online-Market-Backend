package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Item;

import java.util.List;

public interface OrderService {

    public void saveOrder();
    public List<Item> getAllOrder();
    public Item getOrderById(long id);
    public void deleteOrderById(long id);
    public void UpdateOrderById(long id);
}
