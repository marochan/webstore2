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


        CartItem findByCartItemId(Integer cartItemId);
}
