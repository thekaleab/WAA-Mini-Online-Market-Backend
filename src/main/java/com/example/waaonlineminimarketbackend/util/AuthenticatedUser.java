package com.example.waaonlineminimarketbackend.util;

import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.repository.UserRepository;
import com.example.waaonlineminimarketbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUser {
    @Autowired
    UserRepository userRepository;

    public User getCurrentUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetail =(UserDetails) auth.getDetails();
//        User user = userRepository.findByEmail(userDetail.getUsername());
        User user = userRepository.getById(18L);
        return user;
    }
}
