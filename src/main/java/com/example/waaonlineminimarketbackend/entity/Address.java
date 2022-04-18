package com.example.waaonlineminimarketbackend.entity;


import com.example.waaonlineminimarketbackend.entity.enums.Address_Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne
    @JsonIgnore
    private Buyer buyer;

    private Address_Type address_type;




}
