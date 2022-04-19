package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import com.example.waaonlineminimarketbackend.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserInputDto userD){
        try {
            userService.saveUser(userD);
        } catch(BadRequestException e) {
            System.out.println(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> getAlluser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public UserOutputDto getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable long id, User user){


    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id){
        System.out.println(id);
        userService.deleteUserById(id);
    }
}
