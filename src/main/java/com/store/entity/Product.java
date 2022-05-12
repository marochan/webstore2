package com.store.entity;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private Integer product_id;
    private String product_name;
    private int amount_available;
}
