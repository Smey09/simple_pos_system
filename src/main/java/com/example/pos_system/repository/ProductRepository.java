package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.models.Products;

public interface ProductRepository extends JpaRepository<Products, String> {

}
