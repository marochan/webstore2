package com.store.repo;

import com.store.entity.PurchaseItem;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemRepo extends CrudRepository<PurchaseItem, Long> {

    @Query("SELECT PRICE FROM PURCHASE_ITEM WHERE PURCHASE_ITEM_ID = :id")
    Double findPriceByPurchaseItemId(@Param("id") Integer orderItemId);

    PurchaseItem findByPurchaseItemId(Integer orderItemId);
}
