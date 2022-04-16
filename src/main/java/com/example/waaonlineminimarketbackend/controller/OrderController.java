package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping
    public void addOrder(@RequestBody Order order){
        orderService.saveOrder(order);
    }
    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id){
        return orderService.getOrderById(id);
    }
    @PutMapping("/{id}")
    public void updateOrderById(@PathVariable long id, @RequestBody Order order){
            orderService.UpdateOrderById(id, order);
    }
    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable long id){
        orderService.deleteOrderById(id);

    }
}
