package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderItemStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderItemOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
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
    public List<OrderOutputDto> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/seller/items/{id}")
    public List<OrderItemOutputDto> getAllOrderItemsBySeller(@PathVariable long id) {
        return orderService.getAllOrderItemsBySeller(id);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/buyer/{id}")
    public List<OrderOutputDto> getByBuyer(@PathVariable long id){
        return orderService.getByBuyer(id);
    }

    @GetMapping("/seller/{id}")
    public List<OrderOutputDto> getBySeller(@PathVariable long id) {
        return orderService.getAllOrdersBySeller(id);
    }

    @PutMapping("/{id}")
    public void updateOrderById(@PathVariable long id, @RequestBody OrderStatus orderD){
            orderService.UpdateOrderById(id, orderD);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable long id, @RequestBody OrderStatusInputDto statusDto){
        try {
            orderService.updateStatus(id, statusDto);
            return ResponseEntity.ok("success");
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/item/status/{id}")
    public ResponseEntity<?> updateOrderItemStatus(@PathVariable long id, @RequestBody OrderItemStatusInputDto orderItemStatusInputDto){
        try {
            orderService.updateOrderItemStatus(id, orderItemStatusInputDto);
            return ResponseEntity.ok("success");
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/status")
    public ResponseEntity<?> getAllOrderStatus() {
        return ResponseEntity.ok(orderService.getAllOrderStatus());
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable long id){
        orderService.deleteOrderById(id);

    }
}
