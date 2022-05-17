package com.store.entity;

import org.springframework.data.annotation.Id;

public class PurchaseItem {

    @Id
    private Integer purchaseItemId;

    private long product_id;
    private int amount;
    private Double price;

    public PurchaseItem(Integer purchaseItemId, long product_id, int amount, Double price) {
        this.purchaseItemId = purchaseItemId;
        this.product_id = product_id;
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
