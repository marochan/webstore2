package com.store.controller;

import com.store.entity.Customer;
import com.store.entity.Product;
import com.store.service.customer.CustomerService;
import com.store.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StoreController {


    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAllUsers());
    }

    @PostMapping("/product/add")
    public ResponseEntity<Product> addNewProduct(Map<String, String> data){
        return ResponseEntity.ok(productService.addNewProduct(data));
    }

    @DeleteMapping("/product/remove")
    public ResponseEntity<Void> deleteProduct(@RequestParam("productId") Long productId){
        productService.removeProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
