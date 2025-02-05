package com.example.pos_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos_system.models.Orders;
import com.example.pos_system.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders addOrders(Orders orders) {
        return orderRepository.save(orders);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Orders> getOrderById(String order_id) {
        return orderRepository.findById(order_id);
    }

    public void deleteOrder(String order_id) {
        orderRepository.deleteById(order_id);
    }

    public Orders updateOrder(String order_id, Orders updateOrder) {
        return orderRepository.findById(order_id).map(order -> {
            order.setPrice(updateOrder.getPrice());
            order.setDiscount(updateOrder.getDiscount());
            order.setStatus(updateOrder.getStatus());
            order.setCustomer_id(updateOrder.getCustomer_id());
            order.setUser_id(updateOrder.getUser_id());
            order.setCreate_at(updateOrder.getCreate_at());
            return orderRepository.save(order);
        }).orElseGet(() -> {
            updateOrder.setOrder_id(order_id);
            return orderRepository.save(updateOrder);
        });
    }

}
