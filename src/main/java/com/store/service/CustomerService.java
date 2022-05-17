package com.store.service;

import com.store.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Customer findCustomerByEmail(String email);
    void resetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception;
    List<Customer> findAllUsers();
}
