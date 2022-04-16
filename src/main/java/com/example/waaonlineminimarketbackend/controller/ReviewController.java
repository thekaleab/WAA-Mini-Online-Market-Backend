package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    @PostMapping
    public void addReview(@RequestBody Review review){
            reviewService.saveReview(review);
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
