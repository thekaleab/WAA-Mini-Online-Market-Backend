package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AddressController {

    @PostMapping
    public void addAddress(Address address){

    }
    @GetMapping
    public List<Address> getAllAddress(){
        return null;
    }
    @GetMapping
    public Address getAddressById(long id){
        return null;
    }
    @PutMapping
    public void updateAddressById(long id, Address address){

    }
    @DeleteMapping
    public void deleteAddressById(long id){

    }
}