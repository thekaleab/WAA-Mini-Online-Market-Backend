package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Seller;
import com.example.waaonlineminimarketbackend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @GetMapping("/{id}")
    public Seller getSellerById( @PathVariable("id") long id) {
        return sellerService.getSellerById(id);
    }

}
