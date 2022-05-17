package com.store.repo;

import com.store.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {

    Role findByName(String name);
    Role findNameByRoleId(Integer role_id);
}
