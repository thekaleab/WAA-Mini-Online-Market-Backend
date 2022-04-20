package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Role;
import com.example.waaonlineminimarketbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }
}
