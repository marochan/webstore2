package com.store.service;

import com.store.entity.Purchase;

public interface PurchaseService {

    Purchase createANewOrder(String email);
    int cancelOrder(Integer order_id);
}
