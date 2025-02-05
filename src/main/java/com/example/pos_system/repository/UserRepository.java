package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.models.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}
