package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @PostMapping
    public void addOrder(Order order){

    }
    @GetMapping
    public List<Order> getAllOrder(){
        return null;
    }
    @GetMapping("/{id}")
    public Address getOrderById(long id){
        return null;
    }
    @PutMapping("/{id}")
    public void updateOrderById(long id, Order order){

    }
    @DeleteMapping("/{id}")
    public void deleteOrderById(long id){

    }
}
