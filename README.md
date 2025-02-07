E-Commerce Database Schema
This project contains a database schema for an e-commerce system. The schema includes tables for users, customers, orders, payments, products, categories, and order items.

## Technology
 * Back-end
    -- Java Spring Boot (Version 21)
 * Database
    -- PosgresSQL 17

- > get my pos-system-api.postman_collection.json for test api

## Database Tables
<img width="1084" alt="Screenshot 2025-02-05 at 9 42 14 in the morning" src="https://github.com/user-attachments/assets/4d8dad90-ca60-49db-a260-6baf39e4421b" />

1. Users
Stores user information such as username, email, password, role, and created_at.
-- CRUD Operations: Create, Read, Update, Delete.
2. Customers
Stores customer details including name, phone, email, and created_at.
-- CRUD Operations: Create, Read, Update, Delete.
3. Orders
Stores orders placed by customers and linked to users.
Contains price, discount, final price, status, and timestamps.
-- CRUD Operations: Create, Read, Update, Delete.
4. Payments
Stores payment transactions related to orders.
Contains payment type, amount, and timestamp.
-- CRUD Operations: Create, Read, Delete (Update is NOT allowed).
5. Order Items
Represents products associated with each order.
Stores product quantity, unit price, and subtotal.
-- CRUD Operations: Create, Read, Update, Delete.
6. Products
Stores product details such as name, description, price, stock, and barcode.
-- CRUD Operations: Create, Read, Update, Delete.
7. Categories
Stores product categories.
-- CRUD Operations: Create, Read, Update, Delete.


## API Endpoints

```
    http://localhost:9999/api/v1.0.0/
```

Special Note:
Payments cannot be updated after creation.

Swagger-ui
```
http://localhost:9999/swagger-ui/index.html
```
```
# API Port Configuration
server.port=9999

# Database Configuration (PostgreSQL)
spring.application.name=pos-system
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=postgres
spring.datasource.password=your_password

# JPA Configuration
# spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Spring Security default user credentials
spring.security.user.name=admin
spring.security.user.password=admin123
```


© 2025 By Roem Reaksmey. All rights reserved.

This database schema is designed for managing an e-commerce system, covering users, customers, orders, payments, products, categories, and order items.

