package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(UserInputDto user){
        userService.saveUser(user);

    }
    @GetMapping
    public List<UserInputDto> getAlluser(){
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public UserInputDto getUserById(long id){
//        return userService.getUserById(id);
        return null;
    }

    @PutMapping("/{id}")
//    public void updateUserById(long id, User user){
//
//
//    }
    @DeleteMapping("/{id}")
    public void deleteUserById(long id){
        userService.deleteUserById(id);
    }
}
