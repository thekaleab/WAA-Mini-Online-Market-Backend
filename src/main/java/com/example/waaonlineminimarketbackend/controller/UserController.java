package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserUpdateInputDto;
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
    public ResponseEntity<?> addUser(@RequestBody UserInputDto userD){
        try {
            userService.saveUser(userD);
            return ResponseEntity.ok("User successfully created");
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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
    public void updateUserById(@PathVariable long id, @RequestBody UserUpdateInputDto userUpdateInputDto){
        userService.UpdateUserById(id, userUpdateInputDto);


    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id){
        System.out.println(id);
        userService.deleteUserById(id);
    }
    @PutMapping("/follow/{id}")
    public void followSeller(@PathVariable long id){
        userService.followSeller(id);
    }
}
