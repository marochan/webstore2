package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class OrderItem {
    @Id
    @Column("ORDER_ITEM_ID")
    private Integer orderItemId;

    private long product_id;
    private int amount;
    private double price;

    public OrderItem(Integer cartItemId, long product_id, int amount, double price) {
        this.orderItemId = cartItemId;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
    }

    public OrderItem() {
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
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
