package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Item;

import java.util.List;

public interface ItemService {
    public void saveItem();
    public List<Item> getAllItem();
    public Item getItemById(long id);
    public void deleteItemById(long id);
    public void UpdateItemById(long id);
}
