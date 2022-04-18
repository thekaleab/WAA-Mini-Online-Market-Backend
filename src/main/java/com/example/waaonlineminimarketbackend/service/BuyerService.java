package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Buyer;

import java.util.List;

public interface BuyerService {
    
    void saveBuyer(Buyer buyer);
    List<Buyer> getBuyer();
    Buyer getBuyerById(long id);
    void updateBuyer(long id, Buyer buyer);
    void followSeller(long sellerId, long followerId);
}
