package com.store.entity;

import org.springframework.data.annotation.Id;

public class PurchaseItem {

    @Id
    private Integer purchaseItemId;
    private Long productId;
    private int amount;
    private Double price;

    public PurchaseItem(Integer purchaseItemId, Long productId, int amount, Double price) {
        this.purchaseItemId = purchaseItemId;
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }

    public PurchaseItem() {
    }

    public Integer getPurchaseItemId() {
        return purchaseItemId;
    }

    public void setPurchaseItemId(Integer purchaseItemId) {
        this.purchaseItemId = purchaseItemId;
    }

    public Long getProductId() {
        return productId;
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
