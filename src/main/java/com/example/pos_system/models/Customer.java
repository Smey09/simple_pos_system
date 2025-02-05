package com.example.pos_system.models;

import java.time.LocalDateTime;

import com.example.pos_system.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    private String customer_id;
    private String customer_name;
    private String customer_phone;
    private String customer_gmail;
    private LocalDateTime create_at;

    public Customer() {
        this.customer_id = CustomIdGenerator.generateUniqueId();
    }

    public Customer(String customer_name, String customer_phone, String customer_gmail, LocalDateTime create_at) {
        this.customer_id = CustomIdGenerator.generateUniqueId();
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_gmail = customer_gmail;
    }

    @PrePersist
    protected void onCreate() {
        this.create_at = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return customer_id;
    }

    public void setId(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return customer_name;
    }

    public void setName(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone() {
        return customer_phone;
    }

    public void setPhone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getEmail() {
        return customer_gmail;
    }

    public void setEmail(String customer_gmail) {
        this.customer_gmail = customer_gmail;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

}
