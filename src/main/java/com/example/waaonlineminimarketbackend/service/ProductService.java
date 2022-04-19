package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;
import java.util.List;

public interface ProductService {
    public void saveItem(ProductInputDto productD);
    public List<Product> getAllItem();
    public Product getItemById(long id);
    public void deleteItemById(long id);
    public void UpdateItemById(long id, Product item);
}
