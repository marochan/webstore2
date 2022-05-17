package com.store.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    @Id
    private Integer customerId;
    private String email;
    private String password;
    private List<CustomerRoleRef> roles = new ArrayList<>();
    private List<CustomerCartItemRef> products = new ArrayList<>();

    public Customer(Integer customerId, String email, String password) {
        this.customerId = customerId;
        this.email = email;
        this.password = password;
    }


    public void addRole(Role role){
        roles.add(new CustomerRoleRef(this.customerId, role.getRoleId()));
    }

    public void addCartItem(CartItem item){
        products.add(new CustomerCartItemRef(this.customerId,item.getCartItemId()));
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

    public List<CustomerCartItemRef> getProducts() {
        return products;
    }

    public void setProducts(List<CustomerCartItemRef> products) {
        this.products = products;
    }

}
