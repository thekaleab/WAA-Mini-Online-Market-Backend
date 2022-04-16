package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus,Long> {
}
