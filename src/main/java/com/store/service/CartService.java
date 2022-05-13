package com.store.service;

import com.store.entity.Customer;

public interface CartService {
    Customer addItemToCart(String email, long productId, int amount) throws Exception;
    Customer removeProductFromCart(String email, Integer cart_item_id) throws Exception;
    Customer modifyCartContent(String email, Integer cart_item_id, long productId, int newAmount) throws Exception;

}
