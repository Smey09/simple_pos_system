package com.example.pos_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos_system.models.OrderItems;
import com.example.pos_system.models.Orders;
import com.example.pos_system.models.Products;
import com.example.pos_system.service.OrderItemsService;
import com.example.pos_system.service.OrderService;
import com.example.pos_system.service.ProductsService;

@RestController
@RequestMapping("/api/v1.0.0/orderItems")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductsService productsService;

    // Get all Data of OrderItems
    @GetMapping
    public ResponseEntity<List<OrderItems>> getAllOrderItems() {
        try {
            List<OrderItems> orderItemData = orderItemsService.getAllOrderItems();
            if (orderItemData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderItemData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a Data by orderItems_id
    @GetMapping("/{orderItems_id}")
    public ResponseEntity<OrderItems> getOrderItemById(@PathVariable String orderItems_id) {
        try {
            Optional<OrderItems> orderItemsData = orderItemsService.getOrderItemById(orderItems_id);

            if (orderItemsData.isPresent()) {
                return new ResponseEntity<>(orderItemsData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create New orderItem
    @PostMapping
    public ResponseEntity<?> addOrderItems(@RequestBody OrderItems orderItems) {
        try {
            // Extract orderItems_id and product_id from orders
            String orderId = orderItems.getOrder_id();

            String productId = orderItems.getProduct_id();

            // Find order and product by their IDs
            Optional<Orders> orderData = orderService.getOrderById(orderId);

            Products productData = productsService.getProductById(productId);

            if (orderData.isEmpty()) {
                return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
            }

            if (productData == null) {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }

            // Save the order
            OrderItems savedOrderItems = orderItemsService.createOrderItem(orderItems);
            return new ResponseEntity<>(savedOrderItems, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete orderItem
    @DeleteMapping("/{orderItems_id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String orderItems_id) {
        try {
            Optional<OrderItems> orderItemsData = orderItemsService.getOrderItemById(orderItems_id);
            if (orderItemsData.isEmpty()) { // Changed from `== null` to `.isEmpty()`
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }

            orderItemsService.deleteOrderItem(orderItems_id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing order item
    @PutMapping("/{orderItems_id}")
    public ResponseEntity<?> updateOrderItem(@PathVariable String orderItems_id,
            @RequestBody OrderItems orderItemDetails) {
        try {
            Optional<OrderItems> orderItemData = orderItemsService.getOrderItemById(orderItems_id);

            if (orderItemData.isEmpty()) { // Ensure the order item exists
                return new ResponseEntity<>("Order item not found", HttpStatus.NOT_FOUND);
            }

            // Extract orderItems_id and product_id from orders
            String orderId = orderItemDetails.getOrder_id();

            String productId = orderItemDetails.getProduct_id();

            // Find order and product by their IDs
            Optional<Orders> orderData = orderService.getOrderById(orderId);

            Products productData = productsService.getProductById(productId);

            if (orderData.isEmpty()) {
                return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
            }

            if (productData == null) {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }

            // Update the order item with new details
            OrderItems updatedOrderItem = orderItemsService.updateOrderItem(orderItems_id, orderItemDetails);
            return new ResponseEntity<>(updatedOrderItem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
