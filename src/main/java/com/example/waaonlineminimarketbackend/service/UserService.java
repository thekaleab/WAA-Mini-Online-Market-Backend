package com.example.waaonlineminimarketbackend.service;


import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserUpdateDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;

import java.util.List;

public interface UserService {

    public void saveUser(UserInputDto userD);
    public List<UserOutputDto> getAllUser();
    public UserOutputDto getUserById(long id);
    public void deleteUserById(long id);
//    public void UpdateUserById(long id, User user);
    public void UpdateUserStatus(long id, UserUpdateDto userD);
}

