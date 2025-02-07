package com.example.pos_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pos_system.models.Customer;
import com.example.pos_system.models.Orders;
import com.example.pos_system.models.Users;
import com.example.pos_system.service.CustomerService;
import com.example.pos_system.service.OrderService;
import com.example.pos_system.service.UserService;

@RestController
@RequestMapping("/api/v1.0.0/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        try {
            List<Orders> orders = orderService.getAllOrders();
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable String order_id) {
        try {
            Optional<Orders> orderData = orderService.getOrderById(order_id);

            if (orderData.isPresent()) {
                return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Orders orders) {
        try {
            // Extract user_id and customer_id from orders
            String userId = orders.getUser_id();
            String customerId = orders.getCustomer_id();

            // Find Users and Customers by their IDs
            Optional<Users> userData = userService.getUserById(userId);
            Optional<Customer> customerData = customerService.getCustomerById(customerId);

            if (userData.isEmpty()) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
            if (customerData.isEmpty()) {
                return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
            }

            // Save the order
            Orders savedOrder = orderService.addOrders(orders);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{order_id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable String order_id) {
        try {
            Optional<Orders> orderData = orderService.getOrderById(order_id);
            if (orderData.isPresent()) {
                orderService.getOrderById(order_id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{order_id}")
    public ResponseEntity<?> updateOrder(@PathVariable String order_id, @RequestBody Orders updatedOrders) {
        try {
            // Find the existing order
            Optional<Orders> existingOrder = orderService.getOrderById(order_id);
            if (existingOrder.isEmpty()) {
                return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
            }

            // Extract user_id and customer_id from updated order
            String userId = updatedOrders.getUser_id();
            String customerId = updatedOrders.getCustomer_id();

            // Find Users and Customers by their IDs
            Optional<Users> userData = userService.getUserById(userId);
            Optional<Customer> customerData = customerService.getCustomerById(customerId);

            if (userData.isEmpty()) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
            if (customerData.isEmpty()) {
                return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
            }

            // Perform the update
            Orders updatedOrderData = orderService.updateOrder(order_id, updatedOrders);
            return new ResponseEntity<>(updatedOrderData, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
