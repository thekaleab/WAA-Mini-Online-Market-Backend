package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {
}
