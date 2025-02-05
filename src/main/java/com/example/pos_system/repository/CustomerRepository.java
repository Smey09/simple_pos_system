package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
