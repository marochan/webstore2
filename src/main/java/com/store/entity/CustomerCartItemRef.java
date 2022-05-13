package com.store.entity;

public class CustomerCartItemRef {

    private Integer customer;
    private Integer cart_item;

    public CustomerCartItemRef(Integer customer, Integer cart_item) {
        this.customer = customer;
        this.cart_item = cart_item;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getCart_item() {
        return cart_item;
    }

    public void setCart_item(Integer cart_item) {
        this.cart_item = cart_item;
    }
}
