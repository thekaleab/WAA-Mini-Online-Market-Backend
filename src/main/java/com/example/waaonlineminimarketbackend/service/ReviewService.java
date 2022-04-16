package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Review;

import java.util.List;

public interface ReviewService {
    public void saveReview();
    public List<Review> getAllReview();
    public Review getReviewById(long id);
    public void deleteReviewById(long id);
    public void UpdateReviewById(long id);
}