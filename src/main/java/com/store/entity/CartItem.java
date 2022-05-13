package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class CartItem {

    @Id
    @Column("cart_item_id")
    private Integer cartItemId;
    private long product_id;
    private int amount;
    private double price;

    public CartItem(Integer cart_item_id, long product_id, int amount, double price) {
        this.cartItemId = cart_item_id;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
