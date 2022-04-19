package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.dto.input.LoginRequest;
import com.example.waaonlineminimarketbackend.entity.dto.input.RefreshTokenRequest;
import com.example.waaonlineminimarketbackend.entity.dto.output.LoginResponse;
import com.example.waaonlineminimarketbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = null;
        try{
             loginResponse = authService.login(loginRequest);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }



}
