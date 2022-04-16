package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Review;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @PostMapping
    public void addReview(Review review){

    }
    @GetMapping
    public List<Review> getAllReview(){
        return null;
    }
    @GetMapping
    public Address getReviewById(long id){
        return null;
    }
    @PutMapping
    public void updateReviewById(long id, Review review){

    }
    @DeleteMapping
    public void deleteReviewById(long id){

    }
}
