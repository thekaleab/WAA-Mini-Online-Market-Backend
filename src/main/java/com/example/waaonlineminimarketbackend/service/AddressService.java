package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Address;

import java.util.List;

public interface AddressService {
    public void saveAddress(Address address);
    public List<Address> getAllAddress();
    public Address getAddressById(long id);
    public void deleteAddressById(long id);
    public void UpdateAddressById(long id, Address address);

}
