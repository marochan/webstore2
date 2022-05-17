package com.store.service.purchase;

import com.store.entity.*;
import com.store.repo.*;
import com.store.service.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepo purchaseRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CartItemRepo cartItemRepo;
    @Autowired
    ProductDataRepo productDataRepo;
    @Autowired
    PurchaseItemRepo purchaseItemRepo;

    @Override
    @Transactional
    public Purchase createANewOrder(String email) {
        Customer customer = customerRepo.findByEmail(email);
        Purchase purchase = new Purchase(null);
        purchase.setEmail(email);
        List<PurchaseItemRef> purchaseItemRefs = this.getOrderItems(purchase, customer.getProducts());
        purchase.setPurchaseItemRefs(purchaseItemRefs);
        double total = this.calculateTotal(purchaseItemRefs);
        purchase.setTotalPrice(total);
        purchase.setStatus("CREATED");

        customer.setProducts(null);
        customerRepo.save(customer);
        purchaseRepo.save(purchase);
        return purchase;
    }

    @Override
    public int cancelOrder(Integer purchaseId) {
        Purchase purchase = purchaseRepo.findByPurchaseId(purchaseId);
        List<PurchaseItemRef> refs = purchase.getPurchaseItemRefs();
        for(PurchaseItemRef ref : refs){
            PurchaseItem purchaseItem = purchaseItemRepo.findByPurchaseItemId(ref.getPurchaseItem());
            int amount = purchaseItem.getAmount();
            long productId = purchaseItem.getProductId();
            productDataRepo.incrementAmountOf(productId, amount);
            purchaseItemRepo.delete(purchaseItem);
        }
        purchaseRepo.delete(purchase);
        return 0;
    }

    @Override
    public List<Purchase> findAllPurchasesByCustomer(Integer customerId) {
        String email = customerRepo.findEmailByCustomerId(customerId);
        return purchaseRepo.findAllByEmail(email);
    }


    public List<PurchaseItemRef> getOrderItems(Purchase purchase, List<CustomerCartItemRef> refs){
        List<PurchaseItemRef> products = new ArrayList<>();
        for(CustomerCartItemRef c : refs){
            CartItem item = cartItemRepo.findByCartItemId(c.getCart_item());
            PurchaseItem purchaseItem = new PurchaseItem(null, item.getProductId(), item.getAmount(), item.getPrice());
            cartItemRepo.delete(item);
            purchaseItemRepo.save(purchaseItem);
            PurchaseItemRef ref = new PurchaseItemRef(purchase.getPurchaseId(), purchaseItem.getPurchaseItemId());
            products.add(ref);
        }
        return products;
    }

    public double calculateTotal(List<PurchaseItemRef> refs){
        double total = 0.0;
        for(PurchaseItemRef item : refs){
            Double price = purchaseItemRepo.findPriceByPurchaseItemId(item.getPurchaseItem()).doubleValue();
            total+=price.doubleValue();
        }
        return total;
    }
}
