package com.store.service.cart;

import com.store.entity.Customer;

import java.util.Map;

public interface CartService {
    Customer addItemToCart(String email, long productId, int amount) throws Exception;
    Customer removeProductFromCart(String email, Integer cartItemId) throws Exception;
    Customer modifyCartContent(String email, Integer cartItemId, long productId, int newAmount) throws Exception;

    Map<String, Object> findCartItems(Integer customerId);
}
