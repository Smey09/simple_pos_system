package com.example.pos_system.models;

import java.time.LocalDateTime;

import com.example.pos_system.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    private String product_id;

    private String categories_id;

    private String product_name;

    private String product_description;

    private String product_price;

    private String product_stock;

    private String product_barCode;

    private LocalDateTime create_at;

    public Products() {
        this.product_id = CustomIdGenerator.generateUniqueId();
        // this.create_at = LocalDateTime.now();
    }

    public Products(String categories_id, String product_name, String product_description, String product_price,
            String product_stock, String product_barCode, LocalDateTime create_at) {
        this.product_id = CustomIdGenerator.generateUniqueId();
        this.categories_id = categories_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_barCode = product_barCode;
    }

    @PrePersist
    protected void onCreate() {
        this.create_at = LocalDateTime.now();
    }

    // Getters and Setters
    public String getProductId() {
        return product_id;
    }

    public void setProductId(String product_id) {
        this.product_id = product_id;
    }

    public String getCategoriesId() {
        return categories_id;
    }

    public void setCategoriesId(String categories_id) {
        this.categories_id = categories_id;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public String getProductDescription() {
        return product_description;
    }

    public void setProductDescription(String product_description) {
        this.product_description = product_description;
    }

    public String getProductPrice() {
        return product_price;
    }

    public void setProductPrice(String product_price) {
        this.product_price = product_price;
    }

    public String getProductStock() {
        return product_stock;
    }

    public void setProductStock(String product_stock) {
        this.product_stock = product_stock;
    }

    public String getProductBarCode() {
        return product_barCode;
    }

    public void setProductBarCode(String product_barCode) {
        this.product_barCode = product_barCode;
    }

    public LocalDateTime getCreateAt() {
        return create_at;
    }

    public void setCreateAt(LocalDateTime create_at) {
        this.create_at = create_at;
    }

}
