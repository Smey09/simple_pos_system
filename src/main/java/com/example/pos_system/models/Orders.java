package com.example.pos_system.models;

import java.time.LocalDateTime;

import com.example.pos_system.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    private String order_id;
    private String user_id;
    private String customer_id;
    private String price;
    private String discount;
    private String final_price;
    private String status;
    private LocalDateTime create_at;

    public Orders() {
        this.order_id = CustomIdGenerator.generateUniqueId();
    }

    public Orders(String user_id, String customer_id, String price, String discount, String final_price, String status,
            LocalDateTime create_at) {
        this.order_id = CustomIdGenerator.generateUniqueId();
        this.user_id = user_id;
        this.customer_id = customer_id;
        this.price = price;
        this.discount = discount;
        this.final_price = final_price;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        this.create_at = LocalDateTime.now();
    }

    // Getters and Setters
    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getFinal_price() {
        return final_price;
    }

    public void setFinal_price(String final_price) {
        this.final_price = final_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public void setId(String order_id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
