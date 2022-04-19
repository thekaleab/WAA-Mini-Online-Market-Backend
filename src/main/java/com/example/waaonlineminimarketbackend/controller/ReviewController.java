package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody Review review){
        try {
            var result = reviewService.saveReview(review);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Review> getAllReview(){
        return reviewService.getAllReview();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable long id){
        return reviewService.getReviewById(id);
    }
    @PutMapping("/{id}")
    public void updateReviewById(@PathVariable long id, @RequestBody Review review){
        reviewService.UpdateReviewById(id, review);
    }
    @DeleteMapping("/{id}")
    public void deleteReviewById(long id){

    }
}
