package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Buyer;
import com.example.waaonlineminimarketbackend.entity.CartItem;
import com.example.waaonlineminimarketbackend.entity.Item;
import com.example.waaonlineminimarketbackend.service.BuyerService;
import com.example.waaonlineminimarketbackend.service.ShoppingCartService;
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
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping
    public void saveBuyers(@RequestBody Buyer buyer){
        buyerService.saveBuyer(buyer);
    }


    @GetMapping
    public List<Buyer> getAllBuyers() {

        return buyerService.getBuyer();

//        return buyers!=null? new ResponseEntity<>(buyers, HttpStatus.OK): new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{buyerid}/{sellerid}")
    public void followSeller(@PathVariable long buyerid, @PathVariable long sellerid){
        buyerService.followSeller(sellerid,buyerid);
    }



    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable("id") Long id) {
        return buyerService.getBuyerById(id);
    }

    @PutMapping("/{id}")
    public void updateBuyer( @PathVariable("id") Long id,@RequestBody Buyer buyer){
    buyerService.updateBuyer(id,buyer);
    }

    @PostMapping("/cart/{buyerid}")
    public void addToCart(@PathVariable long buyerid, @RequestBody CartItem cartItem){
        shoppingCartService.addToCart(buyerid,cartItem);

    }
    @GetMapping("/cart")
    public List<Item> getAllItemfromCart(){
        return null;
    }
    @PutMapping("/cart")
    public void updateCart(){

    }
    @DeleteMapping("/cart")
    public void deleteCart(){

    }

}
