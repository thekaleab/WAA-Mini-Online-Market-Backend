package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Buyer;
import com.example.waaonlineminimarketbackend.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {

    @Autowired
    BuyerService buyerService;


    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = buyerService.getBuyer();
        return buyers!=null? new ResponseEntity<>(buyers, HttpStatus.OK): new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable("id") Long id) {
        return buyerService.getBuyerById(id);
    }

    @PutMapping("/{id}")
    public void updateBuyer( @PathVariable("id") Long id,@RequestBody Buyer buyer){
    buyerService.updateBuyer(id,buyer);
    }

}
