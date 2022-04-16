package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Role;
import com.example.waaonlineminimarketbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;
    @PostMapping
    public void addRole(@RequestBody Role role){
        roleService.saveRole(role);
    }
    @GetMapping
    public List<Role> getAllRole(){
        return  roleService.getAllRole();
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable long id){
        return roleService.getRoleById(id);
    }
    @PutMapping("/{id}")
    public void updateRoleById(@PathVariable long id, @RequestBody Role role){
                roleService.UpdateRoleById(id, role);
    }
    @DeleteMapping("/{id}")
    public void deleteRoleById(@PathVariable long id){
            roleService.deleteRoleById(id);
    }
}
