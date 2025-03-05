package com.example.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Max
 */
@Document(collection = "mycollection")
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String email;


}
