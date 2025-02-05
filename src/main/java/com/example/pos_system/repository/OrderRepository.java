package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.models.Orders;

public interface OrderRepository extends JpaRepository<Orders, String> {

}
