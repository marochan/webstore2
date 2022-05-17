package com.store.entity;

public class PurchaseItemRef {

    private Integer purchase;
    private Integer purchaseItem;


    public PurchaseItemRef(Integer purchase, Integer purchaseItem) {
        this.purchase = purchase;
        this.purchaseItem = purchaseItem;
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Integer getPurchaseItem() {
        return purchaseItem;
    }

    public void setPurchaseItem(Integer purchaseItem) {
        this.purchaseItem = purchaseItem;
    }
}
