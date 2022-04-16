package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Review;

import java.util.List;

public interface ReviewService {
     void saveReview(Review review);
     List<Review> getAllReview();
     Review getReviewById(long id);
     void deleteReviewById(long id);
     void UpdateReviewById(long id, Review review);
}