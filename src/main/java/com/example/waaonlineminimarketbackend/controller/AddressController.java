package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/address")
public class AddressController {

     @Autowired
    AddressService addressService;

    @PostMapping
    public void addAddress(@RequestBody Address address){

    }
    @GetMapping
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable long id){
        return addressService.getAddressById(id);
    }
    @PutMapping("/{id}")
    public void updateAddressById(@PathVariable long id, @RequestBody Address address){
       addressService.UpdateAddressById(id,address);
    }
    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable long id){
      addressService.deleteAddressById(id);
    }
}
