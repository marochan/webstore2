package com.store.repo;

import com.store.entity.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends CrudRepository<CartItem, Long> {

}
