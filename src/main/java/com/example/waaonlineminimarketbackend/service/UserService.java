package com.example.waaonlineminimarketbackend.service;


import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;

import java.util.List;

public interface UserService {

    public void saveUser(UserInputDto user);
    public List<UserInputDto> getAllUser();
    public User getUserById(long id);
    public void deleteUserById(long id);
//    public void UpdateUserById(long id, User user);
}

