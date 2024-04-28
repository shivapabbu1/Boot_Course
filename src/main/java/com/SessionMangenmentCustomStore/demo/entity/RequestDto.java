package com.SessionMangenmentCustomStore.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RequestDto {

	@Id
    private String username;
    private String password;

    // getters and setters
}