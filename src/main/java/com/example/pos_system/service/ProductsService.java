package com.example.pos_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos_system.models.Products;
import com.example.pos_system.repository.ProductRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    // Get a product by ID
    public Products getProductById(String product_id) {
        return productRepository.findById(product_id).orElse(null);
    }

    // Get all products
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    // Save a product
    public Products saveProduct(Products products) {
        return productRepository.save(products);
    }

    // Delete a product
    public void deleteProduct(String product_id) {
        productRepository.deleteById(product_id);
    }

    // Update a product
    public Products updateProduct(String product_id, Products updatedProduct) {
        return productRepository.findById(product_id).map(product -> {
            product.setProductName(updatedProduct.getProductName());
            product.setCategoriesId(updatedProduct.getCategoriesId());
            product.setProductDescription(updatedProduct.getProductDescription());
            product.setProductPrice(updatedProduct.getProductPrice());
            product.setCreateAt(updatedProduct.getCreateAt());
            // product.setProductStock(updatedProduct.getProductStock());
            // product.setProductBarCode(updatedProduct.getProductBarCode());
            return productRepository.save(product);
        }).orElseGet(() -> {
            updatedProduct.setProductId(product_id);
            return productRepository.save(updatedProduct);
        });
    }

}
