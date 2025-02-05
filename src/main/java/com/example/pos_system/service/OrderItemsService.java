package com.example.pos_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.pos_system.models.OrderItems;
import com.example.pos_system.repository.OrderItemsReposotory;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsReposotory orderItemsReposotory;

    // Method to retrieve all OrderItems
    public List<OrderItems> getAllOrderItems() {
        return orderItemsReposotory.findAll();
    }

    // Method to retrieve a specific OrderItem by its ID
    public Optional<OrderItems> getOrderItemById(String id) {
        return orderItemsReposotory.findById(id);
    }

    // public Orders addOrders(Orders orders) {
    // return orderRepository.save(orders);
    // }

    // // Method to create a new OrderItem
    // public OrderItems createOrderItem(OrderItems orderItem) {
    // orderItem.setOrderItems_id(CustomIdGenerator.generateUniqueId());
    // return orderItemsReposotory.save(orderItem);
    // }

    // Method to create a new OrderItem
    public OrderItems createOrderItem(OrderItems orderItem) {
        return orderItemsReposotory.save(orderItem);
    }

    // Method to update an existing OrderItem
    public OrderItems updateOrderItem(String id, OrderItems orderItemDetails) {
        OrderItems orderItem = orderItemsReposotory.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        orderItem.setOrder_id(orderItemDetails.getOrder_id());
        orderItem.setProduct_id(orderItemDetails.getProduct_id());
        orderItem.setQuantity(orderItemDetails.getQuantity());
        orderItem.setUnit_price(orderItemDetails.getUnit_price());
        orderItem.setSubtotal(orderItemDetails.getSubtotal());
        return orderItemsReposotory.save(orderItem);
    }

    // Method to delete an OrderItem by its ID
    public void deleteOrderItem(String id) {
        orderItemsReposotory.deleteById(id);
    }
}
