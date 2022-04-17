package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.repository.ReviewRepository;
import com.example.waaonlineminimarketbackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void saveReview(Review review) {
     reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        return reviewRepository.getById(id);
    }

    @Override
    public void deleteReviewById(long id) {
         reviewRepository.deleteById(id);

    }

    @Override
    public void UpdateReviewById(long id, Review rv) {
        var review = reviewRepository.getById(id);
//        review.setReviewId(rv.getReviewId());
//        review.setName(rv.getName());

    }
}
