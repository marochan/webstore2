package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;


@Table("ORDERS")
public class Order {

    @Id
    @Column("ORDER_ID")
    private Integer orderId;

    private String email;

    private List<OrderOrderItemRef> cartItemsRefs = new ArrayList<>();

    private double totalPrice;

    private String status;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderOrderItemRef> getCartItemsRefs() {
        return cartItemsRefs;
    }

    public void setCartItemsRefs(List<OrderOrderItemRef> cartItemsRefs) {
        this.cartItemsRefs = cartItemsRefs;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Order(Integer orderId) {
        this.orderId = orderId;
    }
}
