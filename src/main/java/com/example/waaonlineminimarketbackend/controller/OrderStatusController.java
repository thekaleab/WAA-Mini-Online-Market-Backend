package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OrderStatusController {
    @PostMapping
    public void addOrderStatus(OrderStatus orderStatus){

    }
    @GetMapping
    public List<OrderStatus> getOrderStatus(){
        return null;
    }
    @GetMapping
    public OrderStatus getAddressById(long id){
        return null;
    }
    @PutMapping
    public void updateOrderStatusById(long id, OrderStatus orderStatus){

    }
    @DeleteMapping
    public void deleteOrderStatusById(long id){

    }
}
