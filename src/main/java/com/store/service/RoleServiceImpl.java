package com.store.service;

import com.store.entity.Role;
import com.store.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepo roleRepo;
    @Override
    public Role addNewRole(Role role) {
        return roleRepo.save(role);
    }
}
