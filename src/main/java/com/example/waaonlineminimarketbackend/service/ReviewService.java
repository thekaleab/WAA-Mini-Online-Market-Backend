package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.entity.dto.input.ReviewInputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    Review saveReview(Review review) throws BadRequestException;

     List<Review> getAllReview();

     Review getReviewById(long id);

     void deleteReviewById(long id);

     void UpdateReviewById(long id, Review review);

     void UpdateReviewStatus(long id, ReviewInputDto reviewD);
}