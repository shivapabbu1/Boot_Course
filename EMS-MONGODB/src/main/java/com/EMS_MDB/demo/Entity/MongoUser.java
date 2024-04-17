package com.EMS_MDB.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value= "users")
@Data

public class MongoUser {

    @Id // Denotes the primary key field
    private String id;
    private String name;
    private String surname;
    private String email;
}