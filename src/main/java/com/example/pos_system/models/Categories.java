package com.example.pos_system.models;

import com.example.pos_system.utils.CustomIdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categories")
public class Categories {

    @Id
    private String categories_id;
    private String categories_name;

    public Categories() {
        this.categories_id = CustomIdGenerator.generateUniqueId();
    }

    public Categories(String categories_name) {
        this.categories_id = CustomIdGenerator.generateUniqueId();
        this.categories_name = categories_name;
    }

    // Getters and Setters
    public String getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(String categories_id) {
        this.categories_id = categories_id;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }

    public void setId(String categories_id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
