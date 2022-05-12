package com.store.entity;

public class CartItemRef {
    private int customer;
    private int cart_item;

    public CartItemRef(int customer, int cart) {
        this.customer = customer;
        this.cart_item = cart;
    }
}
