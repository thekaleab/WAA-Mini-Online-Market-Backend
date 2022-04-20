package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.entity.dto.input.ReviewInputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.repository.ReviewRepository;
import com.example.waaonlineminimarketbackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;


    @Override
    public Review saveReview(Review review)  throws BadRequestException {
       try {
           review.setApproved(false);
           return reviewRepository.save(review);
       }catch (Exception e){
            throw new BadRequestException();
        }
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
      review.setId(rv.getId());
      review.setContent(rv.getContent());

    }

    @Override
    public void UpdateReviewStatus(long reviewId, ReviewInputDto reviewD) {
        var productId = reviewD.getProductId();
        var product = productRepository.getById(productId);
        var reviews = product.getReviews();
        var review = reviews.stream().filter(rv->(rv.getId() == reviewId)).findFirst().orElse(null);
        review.setApproved(reviewD.getStatus());
        reviewRepository.save(review);
    }

}
