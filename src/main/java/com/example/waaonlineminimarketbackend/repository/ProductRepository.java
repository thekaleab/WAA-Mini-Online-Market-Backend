package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // seller id role is assumed to be 3;
    @Query("select p from Product p where p.seller.id=:id AND p.seller.role.id = 3")
    List<Product> findSellerProducts(long id);

    @Query("select p.seller from Product p where p.id = :id")
    User findProductSeller(long id);
}
