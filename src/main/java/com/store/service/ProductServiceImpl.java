package com.store.service;

import com.store.entity.Product;
import com.store.entity.Purchase;
import com.store.repo.ProductDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDataRepo productDataRepo;
    @Override
    public Product addNewProduct(Map<String, String> data) {
        String name = data.get("product_name");
        int amount = Integer.valueOf(data.get("amount"));
        double price = Double.valueOf(data.get("price"));
        Product product = new Product(null, name, amount, price);
        productDataRepo.save(product);
        return product;
    }

    @Override
    public void removeProduct(Long productId) {
        Product product = productDataRepo.findByProductId(productId);
        if(product.equals(null)){
            throw new IllegalArgumentException("Incorrect product ID!");
        }
        productDataRepo.delete(product);
    }

}
