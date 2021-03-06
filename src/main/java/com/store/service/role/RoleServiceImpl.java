package com.store.service.role;

import com.store.entity.Role;
import com.store.repo.RoleRepo;
import com.store.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepo roleRepo;
    @Override
    public Role addNewRole(Role role) {
        return roleRepo.save(role);
    }
}
