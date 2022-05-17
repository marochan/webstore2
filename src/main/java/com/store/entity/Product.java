package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Product {

    @Id
    @Column("PRODUCT_ID")
    private Long productId;
    @Column("PRODUCT_NAME")
    private String product_name;
    private int amount_available;
    private double price;
    public Product(Long product_id, String product_name, int amount_available, double price) {
        this.productId = product_id;
        this.product_name = product_name;
        this.amount_available = amount_available;
        this.price = price;
    }

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
