package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public void addUser(User user){

    }
    @GetMapping
    public List<User> getAlluser(){
        return null;
    }
    @GetMapping
    public Address getUserById(long id){
        return null;
    }
    @PutMapping
    public void updateUserById(long id, User user){

    }
    @DeleteMapping
    public void deleteUserById(long id){

    }
}
