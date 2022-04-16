package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RoleController {
    @PostMapping
    public void addRole(Role role){

    }
    @GetMapping
    public List<Role> getAllRole(){
        return null;
    }
    @GetMapping
    public Address getRoleById(long id){
        return null;
    }
    @PutMapping
    public void updateRoleById(long id, Role role){

    }
    @DeleteMapping
    public void deleteRoleById(long id){

    }
}
