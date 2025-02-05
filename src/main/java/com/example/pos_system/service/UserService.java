package com.example.pos_system.service;

import com.example.pos_system.models.Users;
import com.example.pos_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users addUser(Users users) {
        return userRepository.save(users);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(String user_id) {
        return userRepository.findById(user_id);
    }

    public Users updateUser(String user_id, Users updatedUser) {
        return userRepository.findById(user_id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            user.setCreate_at(updatedUser.getCreate_at());
            return userRepository.save(user);
        }).orElseGet(() -> {
            updatedUser.setId(user_id);
            return userRepository.save(updatedUser);
        });
    }

    public void deleteUser(String user_id) {
        userRepository.deleteById(user_id);
    }
}
