package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.Role;

import java.util.List;

public interface RoleService {

        public void saveRole();
        public List<Role> getAllRole();
        public Role getRoleById(long id);
        public void deleteRoleById(long id);
        public void UpdateRoleById(long id);

    }



