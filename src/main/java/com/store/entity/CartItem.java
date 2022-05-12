package com.store.entity;

import org.springframework.data.annotation.Id;

public class CartItem {

    @Id
    private Integer cart_item_id;
    private long product_id;
    private int amount;
    private double price;
}
