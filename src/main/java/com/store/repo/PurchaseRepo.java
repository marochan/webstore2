package com.store.repo;

import com.store.entity.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepo extends CrudRepository<Purchase, Long> {
    Purchase findByPurchaseId(Integer purchaseId);
    List<Purchase> findAllByEmail(String email);
}
