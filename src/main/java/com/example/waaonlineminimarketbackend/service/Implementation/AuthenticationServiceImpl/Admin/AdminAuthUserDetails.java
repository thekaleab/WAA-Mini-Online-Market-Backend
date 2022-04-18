package com.example.waaonlineminimarketbackend.service.Implementation.AuthenticationServiceImpl.Admin;


import com.example.waaonlineminimarketbackend.entity.Admin;
import com.example.waaonlineminimarketbackend.entity.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AdminAuthUserDetails implements UserDetails {

    private String user;

    @JsonIgnore
    private String password;

    private List<String> roles;

    public AdminAuthUserDetails(Admin admin) {
        this.user = admin.getEmail();
        this.password = admin.getPassword();
        this.roles = new ArrayList<>(Arrays.asList("ADMIN"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ADMIN"))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
