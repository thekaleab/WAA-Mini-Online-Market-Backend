package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Seller;
import com.example.waaonlineminimarketbackend.repository.SellerRepository;
import com.example.waaonlineminimarketbackend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public void saveSeller(Seller seller) {
        sellerRepository.save(seller);

    }

    @Override
    public Seller getSellerById(long id) {
        return sellerRepository.getById(id);
    }
}
