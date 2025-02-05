package com.example.pos_system.utils;

import java.util.UUID;

public class CustomIdGenerator {
    public static String generateUniqueId() {
        // Generate a random UUID and take the first 8 characters
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }
}
