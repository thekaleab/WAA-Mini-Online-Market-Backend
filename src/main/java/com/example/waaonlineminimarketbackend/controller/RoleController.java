package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @PostMapping
    public void addRole(Role role){

    }
    @GetMapping
    public List<Role> getAllRole(){
        return null;
    }
    @GetMapping("/{id}")
    public Address getRoleById(long id){
        return null;
    }
    @PutMapping("/{id}")
    public void updateRoleById(long id, Role role){

    }
    @DeleteMapping("/{id}")
    public void deleteRoleById(long id){

    }
}
