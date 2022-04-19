package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.dto.input.LoginRequest;
import com.example.waaonlineminimarketbackend.entity.dto.input.RefreshTokenRequest;
import com.example.waaonlineminimarketbackend.entity.dto.output.LoginResponse;
import com.example.waaonlineminimarketbackend.security.JwtUtil;
import com.example.waaonlineminimarketbackend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtHelper;
    @Override
    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("wrong password");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getEmail());

        final String accessToken = jwtHelper.generateToken(userDetails);
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        jwtHelper.getSubject(refreshTokenRequest.getRefreshToken());
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
//            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));  TODO
//            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
//            return loginResponse;
        }
        return new LoginResponse();
    }
}
