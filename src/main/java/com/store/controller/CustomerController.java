package com.store.controller;

import com.store.entity.Customer;
import com.store.repo.CustomerRepo;
import com.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepo customerRepo;
    @GetMapping("/user")
    public ResponseEntity<Customer> findUserByEmail(@RequestBody Map<String, String> data){
        return ResponseEntity.ok().body(customerRepo.findByEmail(data.get("email")));
    }

    @PostMapping("/user")
    public ResponseEntity<Customer> registerNewCustomer(@RequestBody Map<String, String> data){
        return ResponseEntity.ok(customerService.saveCustomer(new Customer(null, data.get("email"), data.get("password"))));
    }
}
