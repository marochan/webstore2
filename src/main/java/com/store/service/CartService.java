package com.store.service;

import com.store.entity.Customer;

public interface CartService {
    Customer addItemToCart(String email, long productId, int amount) throws Exception;
    Customer removeProductFromCart(String email, long productId) throws Exception;
    Customer modifyCartContent(String email, long productId, int newAmount) throws Exception;
}
