package com.example.waaonlineminimarketbackend.repository;

import com.example.waaonlineminimarketbackend.entity.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
}
