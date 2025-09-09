package com.example.splitwise.models;

import com.example.splitwise.Strategy.SettleUpStrategy;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseClass{
    private String name;
    private String email;
    private String password;

}

/**
 * This is the User class which extends BaseClass.
 * 1. It represents a user in the application with fields for name, email, and password.
 * 2. The class inherits common fields from BaseClass such as id, createdAt, and updatedAt.
 * 3. The class uses Lombok annotations to automatically generate getter and setter methods for its fields.
 */

