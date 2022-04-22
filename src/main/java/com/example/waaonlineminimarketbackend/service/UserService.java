package com.example.waaonlineminimarketbackend.service;


import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserUpdateDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserUpdateInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import com.example.waaonlineminimarketbackend.exceptions.NotFoundException;

import java.util.List;

public interface UserService {


    public void saveUser(UserInputDto userD) throws BadRequestException;
    public List<UserOutputDto> getAllUser() ;
    public UserOutputDto getUserById(long id) ;
    public void deleteUserById(long id) ;
    public void UpdateUserById(long id, UserUpdateInputDto userUpdateInputDto);
    public void UpdateUserStatus(long id, UserUpdateDto userD) ;
    public void UpdateUserPoint(long id);
    public void followSeller(long id);
}

