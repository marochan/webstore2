package com.store.repo;

import com.store.entity.CartItem;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends CrudRepository<CartItem, Long> {
        void deleteByCartItemId(Integer cartItemId);

        @Query("SELECT * FROM CART_ITEM WHERE CUSTOMER = :customer")
        List<CartItem> getCart(@Param("customer") Integer customerId);

        CartItem findByCartItemId(Integer cartItemId);
}
