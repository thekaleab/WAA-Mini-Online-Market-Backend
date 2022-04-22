package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query(
            value = "SELECT * FROM review r WHERE r.product_id =: id",
            nativeQuery = true)
    List<Review> findAllByProductId(long id);
}
