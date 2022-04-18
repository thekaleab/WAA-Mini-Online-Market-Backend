package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.dto.input.LoginRequest;
import com.example.waaonlineminimarketbackend.entity.dto.input.RefreshTokenRequest;
import com.example.waaonlineminimarketbackend.entity.dto.output.LoginResponse;

public interface AuthenticationService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
