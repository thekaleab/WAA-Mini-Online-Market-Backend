package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
