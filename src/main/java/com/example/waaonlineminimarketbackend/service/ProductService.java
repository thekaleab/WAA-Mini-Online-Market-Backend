package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Product;

import java.util.List;

public interface ProductService {
    public void saveItem(Product item);
    public List<Product> getAllItem();
    public Product getItemById(long id);
    public void deleteItemById(long id);
    public void UpdateItemById(long id, Product item);
}
