package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Buyer;
import com.example.waaonlineminimarketbackend.entity.Review;

import java.util.List;

public interface AdminService {
//    List<SellerDto> findAllSellers();
    List<Buyer> findAllBuyers();
    boolean approveSeller(Long id);
    List<Review> findUnapprovedReviews();
}
