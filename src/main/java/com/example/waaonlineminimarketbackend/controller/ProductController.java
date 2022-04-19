package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;
import com.example.waaonlineminimarketbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public void addItem(@RequestBody ProductInputDto productD){
        productService.saveItem(productD);

    }
    @GetMapping
    public List<Product> getAllItem() {

        return productService.getAllItem();
    }

    @GetMapping("/{id}")
    public Product getItmeById(@PathVariable long id){
        return productService.getItemById(id);
    }
    @PutMapping("/{id}")
    public void updateItemById(@PathVariable long id, @RequestBody Product item){
        productService.UpdateItemById(id, item);

    }
    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable long id){
        productService.deleteItemById(id);
    }
}
