package com.store.entity;

import org.springframework.data.annotation.Id;

public class CartItem {

    @Id
    private Integer cartItemId;
    private Long productId;
    private int amount;
    private Double price;

    public CartItem(Integer cartItemId, Long productId, int amount, double price) {
        this.cartItemId = cartItemId;
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }

    public CartItem() {
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
