package com.store.service;

import com.store.entity.Product;

import java.util.Map;

public interface ProductService {
    Product addNewProduct(Map<String, String> data);
    void removeProduct(Long productId);

}
