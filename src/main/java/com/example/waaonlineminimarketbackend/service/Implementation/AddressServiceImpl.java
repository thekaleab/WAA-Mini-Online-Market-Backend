package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.repository.AddressRepository;
import com.example.waaonlineminimarketbackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl  implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void saveAddress(Address address) {
    addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        return addressRepository.getById(id);
    }

    @Override
    public void deleteAddressById(long id) {
     addressRepository.deleteById(id);
    }

    @Override
    public void UpdateAddressById(long id, Address add) {
       var address = addressRepository.getById(id);
       address.setState(add.getState());
       address.setId(add.getId());
       address.setZipCode(add.getZipCode());
       address.setCity(add.getCity());
    }
}
