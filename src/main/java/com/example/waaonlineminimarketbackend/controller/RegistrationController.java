//package com.example.waaonlineminimarketbackend.controller;
//
//
//import com.example.waaonlineminimarketbackend.entity.Buyer;
//import com.example.waaonlineminimarketbackend.entity.Seller;
//import com.example.waaonlineminimarketbackend.service.BuyerService;
//import com.example.waaonlineminimarketbackend.service.SellerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/register")
//@CrossOrigin(origins = "http://localhost:3000")
//public class RegistrationController {
//    @Autowired
//    BuyerService buyerService;
//    @Autowired
//    SellerService sellerService;
//
////    @GetMapping("/login")
////    public String LoginPage() {
////        return "Login Here";
////    }
//
//
//    @PostMapping
//    public void registerSeller(@RequestBody Seller seller) {
//        sellerService.saveSeller(seller);
//    }
//
//
//    @PostMapping
//    public void registerBuyer(@RequestBody Buyer buyer) {
//        buyerService.saveBuyer(buyer);
//    }
//
//}
