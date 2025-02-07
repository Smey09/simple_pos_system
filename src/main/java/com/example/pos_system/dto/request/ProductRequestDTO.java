package com.example.pos_system.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String productId;
    private String categoryId;
    private String name;
    private String description;
    private String price;
    private String stock;
    private String barCode;

    // Setters

    public ProductRequestDTO(String productId, String categoryId, String name, String description, String price, String stock, String barCode) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.barCode = barCode;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}

