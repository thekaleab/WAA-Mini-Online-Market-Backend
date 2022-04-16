package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.Role;
import com.example.waaonlineminimarketbackend.repository.RoleRepository;
import com.example.waaonlineminimarketbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(long id) {
        return roleRepository.getById(id);
    }

    @Override
    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }
    @Override
    public void UpdateRoleById(long id, Role rol) {
        var role = roleRepository.getById(id);
        role.setRoleId(rol.getRoleId());
        role.setName(rol.getName());
    }
}
