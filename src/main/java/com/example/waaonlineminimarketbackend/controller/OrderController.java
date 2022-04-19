package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderUpdateInputDto;
import com.example.waaonlineminimarketbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderInputDto orderD){
        try {
            orderService.saveOrder(orderD);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Cannot create order");
        }
    }
    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/buyer/{id}")
    public List<Order> getByBuyer(@PathVariable long id){
        return orderService.getByBuyer(id);
    }

    @PutMapping("/{id}")
    public void updateOrderById(@PathVariable long id, @RequestBody OrderStatus orderD){
            orderService.UpdateOrderById(id, orderD);
    }

    @PutMapping("/status/{id}")
    public void updateStatus(@PathVariable long id, @RequestBody OrderStatusInputDto statusDto){
        orderService.updateStatus(id, statusDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable long id){
        orderService.deleteOrderById(id);

    }
}
