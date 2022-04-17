package com.example.waaonlineminimarketbackend.entity.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInputDto {
    private long userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String role;

}
