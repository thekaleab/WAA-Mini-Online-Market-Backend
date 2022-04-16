package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-status")
public class OrderStatusController {
    @Autowired
    OrderStatusService orderStatusService;
    @PostMapping
    public void addOrderStatus(@RequestBody OrderStatus orderStatus){
            orderStatusService.saveOrderStatus(orderStatus);
    }
    @GetMapping
    public List<OrderStatus> getOrderStatus(){
        return orderStatusService.getAllOrderStatus();
    }
    @GetMapping("/{id}")
    public OrderStatus getOrderStatusById(@PathVariable long id){
        return orderStatusService.getOrderStatusById(id);
    }
    @PutMapping("/{id}")
    public void updateOrderStatusById(@PathVariable long id,@RequestBody OrderStatus orderStatus){
            orderStatusService.UpdateOrderStatusById(id, orderStatus);
    }
    @DeleteMapping("/{id}")
    public void deleteOrderStatusById(@PathVariable long id){

        orderStatusService.deleteOrderStatusById(id);

    }
}
