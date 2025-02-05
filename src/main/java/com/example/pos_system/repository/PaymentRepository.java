package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
