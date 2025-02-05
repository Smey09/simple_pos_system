package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.models.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, String> {

}
