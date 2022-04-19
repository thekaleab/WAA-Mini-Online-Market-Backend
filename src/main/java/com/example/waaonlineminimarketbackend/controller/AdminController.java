package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.dto.input.ReviewInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserUpdateDto;
import com.example.waaonlineminimarketbackend.service.ReviewService;
import com.example.waaonlineminimarketbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/admin")
public class AdminController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @PostMapping("/approve/review/{id}")
    public void UpdateReviewStatus(@PathVariable long id, @RequestBody ReviewInputDto reviewD) {
         reviewService.UpdateReviewStatus(id, reviewD);
    }

    @PostMapping("/approve/seller/{id}")
    public void UpdateUserStatus(@PathVariable long id, @RequestBody UserUpdateDto userD) {
        userService.UpdateUserStatus(id, userD);
    }
}
