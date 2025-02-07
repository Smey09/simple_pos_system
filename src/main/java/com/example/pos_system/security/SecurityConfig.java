package com.example.pos_system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/api/v1.0.0/**").permitAll() // Allow access to Swagger UI
                        .anyRequest().authenticated() // Secure all other endpoints
                )
                .formLogin().permitAll() // Enable form-based login
                .and()
                .logout().permitAll();

        return http.build();
    }
}
