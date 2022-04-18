package com.example.waaonlineminimarketbackend.service.Implementation.AuthenticationServiceImpl.Seller;


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

public class SellerAuthUserDetails implements UserDetails {

    private String user;

    @JsonIgnore
    private String password;

    private List<String> roles;

    public SellerAuthUserDetails(Seller seller) {
        this.user = seller.getEmail();
        this.password = seller.getPassword();
        this.roles = new ArrayList<>(Arrays.asList("SELLER"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("SELLER"))
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
