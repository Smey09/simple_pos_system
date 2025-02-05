package com.example.pos_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos_system.models.Categories;
import com.example.pos_system.repository.CategoriesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    // Create a new category
    public Categories createCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    // Get all categories
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    // Get a category by ID
    public Optional<Categories> getCategoryById(String categories_id) {
        return categoriesRepository.findById(categories_id);
    }

    // Update a category
    public Categories updateCategory(String categories_id, Categories updatedCategory) {
        return categoriesRepository.findById(categories_id).map(categories -> {
            categories.setCategories_name(updatedCategory.getCategories_name());
            return categoriesRepository.save(categories);
        }).orElseGet(() -> {
            updatedCategory.setId(categories_id);
            return categoriesRepository.save(updatedCategory);
        });
    }

    // Delete a category
    public void deleteCategory(String id) {
        categoriesRepository.deleteById(id);
    }
}
