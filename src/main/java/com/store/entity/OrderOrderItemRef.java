package com.store.entity;

public class OrderOrderItemRef {

    private Integer order;
    private Integer order_item;

    public OrderOrderItemRef(Integer order, Integer order_item) {
        this.order = order;
        this.order_item = order_item;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder_item() {
        return order_item;
    }

    public void setOrder_item(Integer order_item) {
        this.order_item = order_item;
    }
}
