package com.store.repo;

import com.store.entity.Product;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends CrudRepository<Product, Long> {

    @Modifying
    @Query("UPDATE PRODUCT SET AVAILABLE_AMOUNT = AVAILABLE - :amount WHERE PRODUCT_ID = :id")
    void decrementAmountOfProduct(@Param("id") Long id, @Param("amount") int amount);
    @Modifying
    @Query("UPDATE PRODUCT SET AVAILABLE_AMOUNT = AVAILABLE + :amount WHERE PRODUCT_ID = :id")
    void incrementAmountOfProduct(@Param("id") Long id, @Param("amount") int amount);
}
