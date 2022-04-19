package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ProductController {

    @Autowired
    ProductService itemService;

    @PostMapping
    public void addItem(@RequestBody Product item){
        itemService.saveItem(item);

    }
    @GetMapping
    public List<Product> getAllItem() {

        return itemService.getAllItem();
    }
    @GetMapping("/{id}")
    public Product getItmeById(@PathVariable long id){
        return itemService.getItemById(id);
    }
    @PutMapping("/{id}")
    public void updateItemById(@PathVariable long id, @RequestBody Product item){
        itemService.UpdateItemById(id, item);

    }
    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable long id){
        itemService.deleteItemById(id);
    }
}
