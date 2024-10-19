# SplitKro: Expense Sharing Application

SplitKro is a robust expense sharing application built with Spring Boot, designed to help users manage shared expenses easily and efficiently.

## Table of Contents
1. [Features](#features)
2. [Technology Stack](#technology-stack)
3. [Getting Started](#getting-started)
4. [API Documentation](#api-documentation)
5. [Database Configuration](#database-configuration)
6. [Swagger UI](#swagger-ui)
7. [Low-Level Design (LLD)](#low-level-design-lld)
8. [High-Level Design (HLD)](#high-level-design-hld)

## Features
- User management
- Group creation and management
- Expense tracking and splitting
- Debt calculation

## Technology Stack
- Java 17
- Spring Boot 3.2.10
- Spring Security
- Spring Data JPA
- PostgreSQL (Supabase)
- Liquibase (for database migrations)
- Swagger (SpringDoc OpenAPI) for API documentation

## Getting Started
1. Clone the repository:
   ```
   git clone https://github.com/yourusername/splitkro.git
   ```
2. Navigate to the project directory:
   ```
   cd splitkro
   ```
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

## API Documentation

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/users` | GET | Retrieve all users |
| `/api/users/{id}` | GET | Retrieve a specific user |
| `/api/users` | POST | Create a new user |
| `/api/users/{id}` | PUT | Update a user |
| `/api/users/{id}` | DELETE | Delete a user |
| `/api/groups` | GET | Retrieve all groups |
| `/api/groups/{id}` | GET | Retrieve a specific group |
| `/api/groups` | POST | Create a new group |
| `/api/groups/{id}` | PUT | Update a group |
| `/api/groups/{id}` | DELETE | Delete a group |
| `/api/expenses` | GET | Retrieve all expenses |
| `/api/expenses/{id}` | GET | Retrieve a specific expense |
| `/api/expenses` | POST | Create a new expense |
| `/api/expenses/{id}` | PUT | Update an expense |
| `/api/expenses/{id}` | DELETE | Delete an expense |

For a more detailed API documentation, please refer to the Swagger UI section below.

## Database Configuration

This application uses PostgreSQL hosted on Supabase. The database connection is configured in the `application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://aws-0-ap-south-1.pooler.supabase.com:6543/postgres
spring.datasource.username=postgres.xnghldgwregxdovykyhn
spring.datasource.password=[YOUR-PASSWORD]
```

Make sure to replace `[YOUR-PASSWORD]` with your actual Supabase database password.

## Swagger UI

Swagger UI is integrated into the application for easy API exploration and testing. Once the application is running, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

![img_1.png](img_1.png)

This interface provides a comprehensive view of all available endpoints, allowing you to test the API directly from your browser.

## Low-Level Design (LLD)

The application follows a layered architecture:

1. **Controller Layer**: Handles HTTP requests and responses.
    - `UserController`: Manages user-related operations
    - `GroupController`: Handles group management
    - `ExpenseController`: Deals with expense tracking and splitting

2. **Service Layer**: Implements business logic.
    - `UserService`: User management logic
    - `GroupService`: Group operations and member management
    - `ExpenseService`: Expense creation, updating, and debt calculation
    - `DebtCalculator`: Utility for calculating debts between users

3. **Repository Layer**: Interfaces with the database.
    - `UserRepository`: Data access for User entities
    - `GroupRepository`: Data access for Group entities
    - `ExpenseRepository`: Data access for Expense entities

4. **Model Layer**: Represents database entities.
    - `User`: Represents a user in the system
    - `Group`: Represents a group of users
    - `Expense`: Represents an expense within a group

5. **DTO Layer**: Data Transfer Objects for API communication.
    - `UserDTO`: User data for API requests/responses
    - `GroupDTO`: Group data for API requests/responses
    - `ExpenseDTO`: Expense data for API requests/responses

6. **Security Configuration**: Handles authentication and authorization.
    - `SecurityConfig`: Configures Spring Security settings

7. **Swagger Configuration**: Sets up API documentation.
    - `SwaggerConfig`: Configures Swagger/OpenAPI settings

## High-Level Design (HLD)

Here's a high-level diagram of the SplitKro application architecture:

![img.png](img.png)

## User level Design:

![img_2.png](img_2.png)

This diagram illustrates the main components of the SplitKro application and how they interact with each other. The application follows a typical Spring Boot architecture with additional components like Swagger for API documentation and Spring Security for authentication.

---

