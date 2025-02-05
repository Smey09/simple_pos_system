package com.example.pos_system.controller;

import com.example.pos_system.models.Categories;
import com.example.pos_system.service.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0.0/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    // Create a new category
    @PostMapping
    public ResponseEntity<Categories> addCategory(@RequestBody Categories category) {
        try {
            Categories savedCategory = categoriesService.createCategory(category);
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all categories
    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories() {
        try {
            List<Categories> categories = categoriesService.getAllCategories();
            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a category by ID
    @GetMapping("/{categories_id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable String categories_id) {
        Optional<Categories> categoryData = categoriesService.getCategoryById(categories_id);
        if (categoryData.isPresent()) {
            return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a category
    @PutMapping("/{categories_id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable String categories_id,
            @RequestBody Categories updatedCategory) {
        try {
            Categories updatedCategoryData = categoriesService.updateCategory(categories_id, updatedCategory);
            return new ResponseEntity<>(updatedCategoryData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a category
    @DeleteMapping("/{categories_id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable String categories_id) {
        try {
            Optional<Categories> categoryData = categoriesService.getCategoryById(categories_id);
            if (categoryData.isPresent()) {
                categoriesService.deleteCategory(categories_id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
