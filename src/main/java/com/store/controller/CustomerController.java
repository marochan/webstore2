package com.store.controller;

import com.store.entity.Customer;
import com.store.entity.Purchase;
import com.store.repo.CustomerRepo;
import com.store.service.cart.CartService;
import com.store.service.customer.CustomerService;
import com.store.service.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CartService cartService;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/user")
    public ResponseEntity<Customer> findUserByEmail(@RequestBody Map<String, String> data){
        return ResponseEntity.ok().body(customerService.findCustomerByEmail(data.get("email")));
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerNewCustomer(@RequestBody Map<String, String> data) throws Exception {
        return ResponseEntity.ok(customerService.registerNewCustomer(data));
    }

    @PostMapping("/cart/add")
    public ResponseEntity<Customer> addItemToCart(@RequestBody Map<String, String> data) throws Exception {
        return ResponseEntity.ok(cartService.addItemToCart(data.get("email"), Integer.parseInt(data.get("product_id")), Integer.parseInt(data.get("amount"))));
    }

    @DeleteMapping("/cart/remove")
    public ResponseEntity<Customer> removeItemFromCart(@RequestBody Map<String, String> data) throws Exception{
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cartService.removeProductFromCart(data.get("email"), Integer.parseInt(data.get("cart_item_id"))));
    }

    @PutMapping("/cart/modify")
    public ResponseEntity<Customer> modifyCartContent(@RequestBody Map<String, String> data ) throws Exception{
        return ResponseEntity.ok(cartService.modifyCartContent(
                data.get("email"),
                Integer.parseInt(data.get("cart_item_id")),
                Integer.parseInt(data.get("product_id")),
                Integer.parseInt(data.get("amount"))
        ));
    }

    @GetMapping("/cart/getCart")
    public ResponseEntity<Map<String, Object>> displayCartContent(@RequestParam("customerId") Integer customerId){
        return ResponseEntity.ok(cartService.findCartItems(customerId));
    }


    @PostMapping("/order/create")
    public ResponseEntity<Purchase> createANewOrder(@RequestBody Map<String, String> data){
        return ResponseEntity.ok(purchaseService.createANewOrder(data.get("email")));
    }

    @DeleteMapping("/order/delete")
    public ResponseEntity<?> cancelOrder(@RequestParam("purchaseId") Integer purchaseId){
        return ResponseEntity.ok(purchaseService.cancelOrder(purchaseId ));
    }

    @GetMapping("/order/getAll")
    public ResponseEntity<List<Purchase>> findAllPurchasesByCustomer(@RequestParam("customerId")Integer customerId){
        return ResponseEntity.ok(purchaseService.findAllPurchasesByCustomer(customerId));
    }

    @PostMapping("/reset")
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception{
        customerService.resetPassword(request, response);
    }
}
