package com.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;


public class Purchase {

    @Id
    private Integer purchaseId;

    private String email;

    private List<PurchaseItemRef> purchaseItemRefs = new ArrayList<>();

    private double totalPrice;

    private String status;

   public Purchase(){

   }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PurchaseItemRef> getPurchaseItemRefs() {
        return purchaseItemRefs;
    }

    public void setPurchaseItemRefs(List<PurchaseItemRef> purchaseItemRefs) {
        this.purchaseItemRefs = purchaseItemRefs;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Purchase(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }
}
