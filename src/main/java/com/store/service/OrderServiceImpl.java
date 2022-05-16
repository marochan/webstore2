package com.store.service;

import com.store.entity.*;
import com.store.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CartItemRepo cartItemRepo;
    @Autowired
    ProductDataRepo productDataRepo;
    @Autowired
    OrderItemRepo orderItemRepo;

    @Override
    @Transactional
    public Order createANewOrder(String email) {
        Customer customer = customerRepo.findByEmail(email);
        Order order = new Order(null);
        order.setEmail(email);
        List<OrderOrderItemRef> orderOrderItemRefs = this.getOrderItems(order, customer.getProducts());
        order.setCartItemsRefs(orderOrderItemRefs);
        double total = this.calculateTotal(orderOrderItemRefs);
        order.setTotalPrice(total);
        order.setStatus("CREATED");

        customer.setProducts(null);
        customerRepo.save(customer);
        orderRepo.save(order);
        return order;
    }

    @Override
    public void cancelOrder(Integer order_id) {
        Order order = orderRepo.findByOrderId(order_id);
        List<OrderOrderItemRef> refs = order.getCartItemsRefs();
        for(OrderOrderItemRef ref : refs){
            OrderItem orderItem = orderItemRepo.findByOrderItemId(ref.getOrder_item());
            int amount = orderItem.getAmount();
            long productId = orderItem.getProduct_id();
            productDataRepo.incrementAmountOf(productId, amount);
            orderItemRepo.delete(orderItem);
        }
    }


    public List<OrderOrderItemRef> getOrderItems(Order order, List<CustomerCartItemRef> refs){
        List<OrderOrderItemRef> products = new ArrayList<>();
        for(CustomerCartItemRef c : refs){
            CartItem item = cartItemRepo.findByCartItemId(c.getCart_item());
            OrderItem orderItem = new OrderItem(null, item.getProduct_id(), item.getAmount(), item.getPrice());
            orderItemRepo.save(orderItem);
            cartItemRepo.delete(item);
            OrderOrderItemRef ref = new OrderOrderItemRef(order.getOrderId(), orderItem.getOrderItemId());
            products.add(ref);
        }
        return products;
    }

    public double calculateTotal(List<OrderOrderItemRef> refs){
        double total = 0.0;
        for(OrderOrderItemRef item : refs){
            double price = orderItemRepo.findPriceByOrderItemId(item.getOrder_item());
            total+=price;
        }
        return total;
    }
}
