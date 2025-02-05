package com.example.pos_system.models;

import java.time.LocalDateTime;

import com.example.pos_system.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    private String payment_id;
    private String order_id;
    private String payment_type;
    private String payment_amount;
    private LocalDateTime pain_at;

    public Payment() {
        this.payment_id = CustomIdGenerator.generateUniqueId();
    }

    public Payment(String order_id, String payment_type, String payment_amount, LocalDateTime pain_at) {
        this.payment_id = CustomIdGenerator.generateUniqueId();
        this.order_id = order_id;
        this.payment_type = payment_type;
        this.payment_amount = payment_amount;
    }

    @PrePersist
    protected void onCreate() {
        this.pain_at = LocalDateTime.now();
    }

    // Getters and Setters
    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(String payment_amount) {
        this.payment_amount = payment_amount;
    }

    public LocalDateTime getPain_at() {
        return pain_at;
    }

    public void setPain_at(LocalDateTime pain_at) {
        this.pain_at = pain_at;
    }

}
