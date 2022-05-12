package com.store.entity;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private Integer product_id;
    private String product_name;
    private int amount_available;
    private double price;
    public Product(Integer product_id, String product_name, int amount_available, double price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.amount_available = amount_available;
        this.price = price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getAmount_available() {
        return amount_available;
    }

    public void setAmount_available(int amount_available) {
        this.amount_available = amount_available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
