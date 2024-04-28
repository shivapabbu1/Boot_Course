package com.SessionMangenmentCustomStore.demo.entity;

import org.springframework.security.core.context.SecurityContext;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="customsessionstore")
@Data
public class Person {

    @Id
    private String sessionId;
    @Column(name = "security_context", length = 400)
    @Lob
    private SecurityContext securityContext;
  
  
	
    
    
    

}
