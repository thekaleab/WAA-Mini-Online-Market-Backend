package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.Role;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;

import java.util.List;

public interface RoleService {
    public List<Role> getAll();
}
