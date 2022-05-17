package com.store.service;

import com.store.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Customer findCustomerByEmail(String email);
    void resetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
