package com.store.service.customer;

import com.store.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    Customer registerNewCustomer(Map<String, String> credentials) throws Exception;
    Customer saveCustomer(Customer customer);
    Customer findCustomerByEmail(String email);
    void resetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception;
    List<Customer> findAllUsers();
}
