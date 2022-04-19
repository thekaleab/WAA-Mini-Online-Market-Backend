package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.ProductOutputDto;

import java.util.List;

public interface ProductService {
    public ProductOutputDto saveItem(ProductInputDto productD);
    public List<Product> getAllItem();
    public Product getItemById(long id);
    public void deleteItemById(long id) throws Exception;
    public ProductOutputDto UpdateItemById(long id, ProductInputDto productD);
}
