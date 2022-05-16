package com.store.service;

import com.store.entity.Customer;

public interface CartService {
    Customer addItemToCart(String email, long productId, int amount) throws Exception;
    Customer removeProductFromCart(String email, Integer cartItemId) throws Exception;
    Customer modifyCartContent(String email, Integer cartItemId, long productId, int newAmount) throws Exception;

}
