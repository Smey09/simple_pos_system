package com.example.pos_system.models;

import com.example.pos_system.utils.CustomIdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItems {

    @Id
    private String orderItems_id;

    private String order_id;
    private String product_id;
    private String quantity;
    private String unit_price;
    private String subtotal;

    public OrderItems() {
        this.orderItems_id = CustomIdGenerator.generateUniqueId();
    }

    // Getters and setters
    public String getOrderItems_id() {
        return orderItems_id;
    }

    public void setOrderItems_id(String orderItems_id) {
        this.orderItems_id = orderItems_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
}
