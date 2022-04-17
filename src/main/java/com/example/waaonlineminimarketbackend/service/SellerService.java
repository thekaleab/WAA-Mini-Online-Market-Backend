package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Seller;

public interface SellerService {
    void saveSeller(Seller seller);
    Seller getSellerById(long id);
}
