package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Item;

import java.util.List;

public interface ReviewService {

    public void saveReview();
    public List<Item> getAllReview();
    public Item getReviewById(long id);
    public void deleteReviewById(long id);
    public void UpdateReviewById(long id);
}
