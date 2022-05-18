package com.store.repo;

import com.store.entity.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

    Customer findByEmail(String email);

    @Query("SELECT EMAIL FROM CUSTOMER WHERE CUSTOMER_ID = :customerId")
    String findEmailByCustomerId(@Param("customerId") Integer customerId);

}
