package com.store.service;

import com.store.entity.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Customer findCustomerByEmail(String email);
}
