package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{
    List<Order> getByBuyerId(long id);
}
