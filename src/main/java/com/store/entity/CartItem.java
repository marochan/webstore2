package com.store.entity;

import org.springframework.data.annotation.Id;

public class CartItem {

    @Id
    private Integer cart_item_id;
    private long product_id;
    private int amount;
    private double price;

    public CartItem(Integer cart_item_id, long product_id, int amount, double price) {
        this.cart_item_id = cart_item_id;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
    }

    public Integer getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(Integer cart_item_id) {
        this.cart_item_id = cart_item_id;
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
