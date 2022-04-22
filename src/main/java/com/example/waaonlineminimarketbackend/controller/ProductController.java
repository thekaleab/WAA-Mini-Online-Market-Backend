package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.ProductOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.ResponseBodyDto;
import com.example.waaonlineminimarketbackend.service.ProductService;
import com.example.waaonlineminimarketbackend.util.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody ProductInputDto productD){
        try {
            var result = productService.saveItem(productD);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllItem() {
        return ResponseEntity.ok(productService.getAllItem());
    }

    @GetMapping("/seller/{id}")
    public List<Product> getSellerProducts(@PathVariable long id) {
        return productService.getAllBySeller(id);
    }

    @GetMapping("/{id}")
    public Product getItemById(@PathVariable long id){
        return productService.getItemById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItemById(@PathVariable long id, @RequestBody ProductInputDto productD){
        var result = productService.UpdateItemById(id, productD);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable long id){
        System.out.println(id);
        try {
            productService.deleteItemById(id);
            return ResponseEntity.accepted().body("Resource deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Product can not be deleted");
        }

    }

    @GetMapping("/reviews/{id}")
    public List<Review> findProductReview(@PathVariable long id) {
        return productService.findAllByProductId(id);
    }
}
