package com.store.service;

import com.store.entity.Order;

public interface OrderService {

    Order createANewOrder(String email);
    void cancelOrder(Integer order_id);
}
