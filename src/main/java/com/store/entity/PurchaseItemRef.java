package com.store.entity;

import org.springframework.data.relational.core.mapping.Column;

public class PurchaseItemRef {

    private Integer purchase;
    private Integer purchase_item;


    public PurchaseItemRef(Integer purchase, Integer purchase_item) {
        this.purchase = purchase;
        this.purchase_item = purchase_item;
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Integer getPurchase_item() {
        return purchase_item;
    }

    public void setPurchase_item(Integer purchase_item) {
        this.purchase_item = purchase_item;
    }
}
