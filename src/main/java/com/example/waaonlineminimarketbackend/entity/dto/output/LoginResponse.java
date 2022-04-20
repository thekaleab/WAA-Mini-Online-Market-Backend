package com.example.waaonlineminimarketbackend.entity.dto.output;

import com.example.waaonlineminimarketbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Role role;
    private String accessToken;
    private String refreshToken;
    private Boolean isSellerApproved;
}
