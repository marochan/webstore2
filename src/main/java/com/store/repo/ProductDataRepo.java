package com.store.repo;

import com.store.entity.Product;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDataRepo extends CrudRepository<Product, Long> {

    @Modifying
    @Query("UPDATE PRODUCT SET AMOUNT_AVAILABLE = AMOUNT_AVAILABLE - :amount WHERE PRODUCT_ID = :id")
    void decrementAmountOf(@Param("id") long product_id, @Param("amount") int amount);
    @Modifying
    @Query("UPDATE PRODUCT SET AMOUNT_AVAILABLE = AMOUNT_AVAILABLE + :amount WHERE PRODUCT_ID = :id")
    void incrementAmountOf(@Param("id") long product_id, @Param("amount") int amount);

    Product findByProductId(long product_id);
}
