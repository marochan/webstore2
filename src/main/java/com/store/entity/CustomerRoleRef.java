package com.store.entity;

public class CustomerRoleRef {
    Integer customer;
    Integer roles;

    public CustomerRoleRef(Integer customer, Integer roles) {
        this.customer = customer;
        this.roles = roles;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}
