package com.example.pos_system.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.example.pos_system.utils.CustomIdGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

    @Id
    private String user_id;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime create_at;

    public Users() {
        this.user_id = CustomIdGenerator.generateUniqueId();
    }

    public Users(String name, String email, String password, String role) {
        this.user_id = CustomIdGenerator.generateUniqueId();
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    protected void onCreate() {
        this.create_at = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return user_id;
    }

    public void setId(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }
}
