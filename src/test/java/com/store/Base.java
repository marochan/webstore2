package com.store;

import com.store.entity.Customer;
import com.store.entity.Role;
import com.store.service.CustomerService;
import com.store.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Base {

    @Autowired
    CustomerService customerService;

    @Test
    public void saveCustomerTest(){

        Customer customer = new Customer(null, "example@example.com","examplepass");
        customer.addRole(new Role(null, "ROLE_ADMIN"));
        customerService.saveCustomer(customer);
        Customer after = customerService.findCustomerByEmail("example@example.com");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(after.getRoles().isEmpty());
    }
}
