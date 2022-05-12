package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("ROLES")
public class Role {
    @Id
    private Integer role_id;
    private String name;

    public Role(Integer role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public Integer getRole_id(){
        return role_id;
    }
    public String getName() {
        return name;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
