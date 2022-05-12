package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Table("CUSTOMER")
public class Customer {

    @Id
    private Integer customer_id;
    private String email;
    private String password;
    private List<CustomerRoleRef> roles = new ArrayList<>();
    private List<CartItemRef> products = new ArrayList<>();
    public Customer(Integer customer_id, String email, String password) {
        this.customer_id = customer_id;
        this.email = email;
        this.password = password;
    }
    public void addRole(Role role){
        roles.add(new CustomerRoleRef(this.customer_id, role.getRole_id()));
    }

    public Integer getId() {
        return customer_id;
    }

    public void setId(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CustomerRoleRef> getRoles() {
        return roles;
    }

    public void setRoles(List<CustomerRoleRef> roles) {
        this.roles = roles;
    }
}