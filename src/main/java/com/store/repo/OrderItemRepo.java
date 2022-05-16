package com.store.repo;

import com.store.entity.OrderItem;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends CrudRepository<OrderItem, Long> {

    @Query("SELECT PRICE FROM ORDER_ITEM WHERE ORDER_ITEM_ID = :id")
    double findPriceByOrderItemId(@Param("id") Integer orderItemId);

    OrderItem findByOrderItemId(Integer orderItemId);
}
