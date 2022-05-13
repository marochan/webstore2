package com.store.service;

import com.store.entity.CartItem;
import com.store.entity.Customer;
import com.store.entity.CustomerCartItemRef;
import com.store.entity.Product;
import com.store.repo.CartItemRepo;
import com.store.repo.CustomerRepo;
import com.store.repo.ProductDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ProductDataRepo productDataRepo;

    @Autowired
    CartItemRepo cartItemRepo;

    @Override
    @Transactional
    public Customer addItemToCart(String email, long productId, int amount) throws Exception {
        Customer customer = customerRepo.findByEmail(email);
        Product product = productDataRepo.findByProductId(productId);
        if(amount > product.getAmount_available()){
            throw new Exception("Provided amount of product exceeds the available amount in the store!");
        }
        double price = product.getPrice() * amount;
        CartItem cartItem = new CartItem(null, productId, amount, price);
        cartItemRepo.save(cartItem);
        customer.addCartItem(cartItem);
        productDataRepo.decrementAmountOf(productId, amount);
        customerRepo.save(customer);
        return customer;
    }

    @Override
    @Transactional
    public Customer removeProductFromCart(String email, Integer cart_item_id) throws Exception {
        Customer customer = customerRepo.findByEmail(email);
        if(customer.getProducts().isEmpty()){
            throw new Exception("Cart empty!");
        }
        CartItem itemToBeDeleted = cartItemRepo.findByCartItemId(cart_item_id);
        customer.removeFromCart(cart_item_id);
        cartItemRepo.delete(itemToBeDeleted);
        productDataRepo.incrementAmountOf(itemToBeDeleted.getProduct_id(), itemToBeDeleted.getAmount());
        return  customer;
    }

    @Override
    @Transactional
    public Customer modifyCartContent(String email,Integer cart_item_id, long productId, int newAmount) throws Exception {
        if(newAmount < 0){
            throw new IllegalArgumentException("Amount cannot be lower than 0!");
        }
        Customer customer = customerRepo.findByEmail(email);
        CartItem cartItem = cartItemRepo.findByCartItemId(cart_item_id);
        int oldAmount = cartItem.getAmount();
        int diff = newAmount - oldAmount;
        if(diff > productDataRepo.findByProductId(productId).getAmount_available()){
            throw new Exception("Provided amount of product exceeds the available amount in the store!");
        } else {
            cartItem.setAmount(newAmount);
            if(diff>0){
                productDataRepo.decrementAmountOf(productId, diff);
            } else {
                productDataRepo.incrementAmountOf(productId, Math.abs(diff));
            }

        }
        return customer;
    }
}
