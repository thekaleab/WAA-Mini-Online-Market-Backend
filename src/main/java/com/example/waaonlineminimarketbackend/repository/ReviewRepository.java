package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Modifying
    @Query("update Review r set r.approved = true where r.id =:id")
    void approveReview(Long id);

    @Modifying
    @Query("update Review  r set r.approved = false where r.id =:id")
    void rejectReview(Long id);
}
