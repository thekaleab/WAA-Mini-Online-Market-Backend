package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.User;

import java.util.List;

public interface UserService {

    public void saveUser();
    public List<User> getAllUser();
    public User getUserById(long id);
    public void deleteUserById(long id);
    public void UpdateUserById(long id);
}

