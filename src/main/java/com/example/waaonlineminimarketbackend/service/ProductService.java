package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.ProductOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;

import java.util.List;

public interface ProductService {
    public ProductOutputDto saveItem(ProductInputDto productD) throws Exception;
    public List<Product> getAllItem();
    public List<Product> getAllBySeller(long id);
    public Product getItemById(long id);
    public void deleteItemById(long id) throws Exception;
    public ProductOutputDto UpdateItemById(long id, ProductInputDto productD);
    public List<Review> findAllByProductId(long id);

    UserOutputDto findProductSeller(long id);
}
