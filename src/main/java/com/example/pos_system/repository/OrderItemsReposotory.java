package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.models.OrderItems;

public interface OrderItemsReposotory extends JpaRepository<OrderItems, String> {

}
