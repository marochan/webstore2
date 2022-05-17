package com.store.service;

import com.store.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase createANewOrder(String email);
    int cancelOrder(Integer order_id);
    List<Purchase> findAllPurchasesByCustomer(Integer customerId);
}
