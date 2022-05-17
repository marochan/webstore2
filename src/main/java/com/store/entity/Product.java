package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Product {

    @Id
    @Column("PRODUCT_ID")
    private Long productId;
    @Column("PRODUCT_NAME")
    private String productName;
    private int amountAvailable;
    private double price;
    public Product(Long product_id, String productName, int amountAvailable, double price) {
        this.productId = product_id;
        this.productName = productName;
        this.amountAvailable = amountAvailable;
        this.price = price;
    }

    public Product() {
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
