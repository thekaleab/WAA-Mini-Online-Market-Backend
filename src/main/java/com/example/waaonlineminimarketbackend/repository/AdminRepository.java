package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.Admin;
import com.example.waaonlineminimarketbackend.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    @Query(value = "select a from Admin a where a.email = :email")
    public Admin loadAdminByEmail(String email);
}