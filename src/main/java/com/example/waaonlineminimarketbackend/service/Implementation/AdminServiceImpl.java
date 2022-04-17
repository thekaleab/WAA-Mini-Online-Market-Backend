package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Buyer;
import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public List<Buyer> findAllBuyers() {
        return null;
    }

    @Override
    public boolean approveSeller(Long id) {
        return false;
    }

    @Override
    public List<Review> findUnapprovedReviews() {
        return null;
    }
}
