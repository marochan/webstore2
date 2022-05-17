package com.store;

import com.store.entity.Customer;
import com.store.entity.Product;
import com.store.entity.Role;
import com.store.repo.ProductDataRepo;
import com.store.service.customer.CustomerService;
import com.store.service.role.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    @Bean
    public CommandLineRunner runner(CustomerService customerService, RoleService roleService, ProductDataRepo productDataRepo){

        return args -> {
            Role user = new Role(null, "ROLE_USER");
            Role admin = new Role(null, "ROLE_ADMIN");
            Product product = new Product(null, "Screwdriwer", 50, 5.40);
            Product productTwo = new Product(null, "Basket", 13, 5);
            productDataRepo.save(product);
            productDataRepo.save(productTwo);
            roleService.addNewRole(user);
            roleService.addNewRole(admin);
            Customer customer = new Customer(null, "example@example.com","examplepass");
            customer.addRole(admin);
            customerService.saveCustomer(customer);
            Customer after = customerService.findCustomerByEmail("example@example.com");
            after.getRoles().forEach(n -> System.out.println(n));
        };

    }
}
