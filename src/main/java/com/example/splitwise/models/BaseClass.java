package com.example.splitwise.models;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseClass {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}

/**
 * BaseClass serves as a base model for other entities in the application.
 * 1. It contains common fields such as id, createdAt, and updatedAt.
 * 2. The id field is used to uniquely identify each instance.
 * 3. createdAt and updatedAt fields are used to track the creation and last update timestamps of the instance.
 * 4. The class uses Lombok annotations to automatically generate getter and setter methods for its fields.
 */
