package com.store.service;

import com.store.entity.Customer;
import com.store.entity.Role;
import com.store.repo.CustomerRepo;
import com.store.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    RoleRepo roleRepo;

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        Role role = roleRepo.findByName("ROLE_USER");
        customer.addRole(role);
        return customerRepo.save(customer);
    }
    @Override
    public Customer findCustomerByEmail(String email){
        return customerRepo.findByEmail(email);
    }

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
}
