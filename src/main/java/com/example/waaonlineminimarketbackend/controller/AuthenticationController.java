package com.example.waaonlineminimarketbackend.controller;


import com.example.waaonlineminimarketbackend.entity.dto.input.LoginRequest;
import com.example.waaonlineminimarketbackend.entity.dto.input.RefreshTokenRequest;
import com.example.waaonlineminimarketbackend.service.AuthenticationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("/authenticate")
public class AuthenticationController{
    RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
    @Autowired
    private AuthenticationService authenticationService;


    static LoginRequest loginRequest;

    @PostMapping("/logins")
    public ResponseEntity<?> sellerLogin(@RequestBody LoginRequest loginRequest) {
        AuthenticationController.loginRequest = loginRequest;
        var loginResponse = authenticationService.login(loginRequest);
        refreshTokenRequest.setRefreshToken(loginResponse.getRefreshToken());
        refreshTokenRequest.setAccessToken(loginResponse.getAccessToken());
        return ResponseEntity.ok().body(loginResponse);
    }

    public static LoginRequest getLoginRequest() {
        return loginRequest;
    }
}
