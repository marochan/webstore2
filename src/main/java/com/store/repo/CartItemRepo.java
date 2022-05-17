package com.store.repo;

import com.store.entity.CartItem;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends CrudRepository<CartItem, Long> {

        @Modifying
        @Query("DELETE FROM CART_ITEM WHERE CART_ITEM_ID = :id")
        long deleteByCartItemId(@Param("id") Integer id);

        @Query("SELECT * FROM CART_ITEM WHERE CART_ITEM_ID IN (SELECT CART_ITEM FROM CUSTOMER_CART_ITEM_REF WHERE CUSTOMER = :customerId)")
        List<CartItem> findCartItems(@Param("customerId") Integer customerId);

        CartItem findByCartItemId(Integer cartItemId);
}
