package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Buyer;
import com.example.waaonlineminimarketbackend.repository.BuyerRepository;
import com.example.waaonlineminimarketbackend.repository.SellerRepository;
import com.example.waaonlineminimarketbackend.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void saveBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @Override
    public List<Buyer> getBuyer() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer getBuyerById(long id) {
        return buyerRepository.getById(id);
    }

    @Override
    public void updateBuyer(long id, Buyer buyer) {
        var buyers = buyerRepository.getById(id);
        buyers.setEmail(buyer.getEmail());
        buyers.setFirstname(buyer.getFirstname());
        buyers.setLastname(buyer.getLastname());
        buyers.setPassword(buyer.getPassword());
        buyers.setPoints(buyer.getPoints());
//        buyers. setReviews(buyer.getReviews());

    }

    @Override
    public void followSeller(long buyerId, long sellerId) {
        var follower = buyerRepository.getById(buyerId);
        var seller = sellerRepository.getById(sellerId);
//        follower.setFollowingSellers(Arrays.asList(seller));
        seller.getFollowers().add(follower);
//        follower.getFollowingSellers().add(seller);
        sellerRepository.save(seller);
        buyerRepository.save(follower);
    }
}
