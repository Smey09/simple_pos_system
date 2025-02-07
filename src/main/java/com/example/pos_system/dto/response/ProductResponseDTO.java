package com.example.pos_system.dto.response;

import com.example.pos_system.models.Products;

import java.time.LocalDateTime;

public class ProductResponseDTO {
    private String productId;
    private String categoryId;
    private String name;
    private String description;
    private String price;
    private String stock;
    private String barCode;
    private LocalDateTime createdAt;

    public ProductResponseDTO(String productId, LocalDateTime createdAt, String barCode, String stock, String price, String description, String name, String categoryId) {
        this.productId = productId;
        this.createdAt = createdAt;
        this.barCode = barCode;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.name = name;
        this.categoryId = categoryId;
    }

// Getters


    public String getProductId() {
        return productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getStock() {
        return stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

