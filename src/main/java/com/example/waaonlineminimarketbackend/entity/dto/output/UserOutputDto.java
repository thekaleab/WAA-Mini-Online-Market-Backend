package com.example.waaonlineminimarketbackend.entity.dto.output;

import com.example.waaonlineminimarketbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOutputDto {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Role role;
}
