package com.cognizant.ormlearn.model; // Matches the folder: src/main/java/com/cognizant/ormlearn/model

import jakarta.persistence.Column;   // Using jakarta.persistence for Spring Boot 3+
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marks this class as a JPA entity, meaning it's mapped to a database table
@Table(name="country") // Specifies the name of the database table this entity maps to
public class Country {

    @Id // Marks this field as the primary key of the entity
    @Column(name="co_code") // Maps this field to the 'co_code' column in the 'country' table
    private String code;

    @Column(name="co_name") // Maps this field to the 'co_name' column in the 'country' table
    private String name;

    // --- Constructors (Optional, but good practice) ---
    public Country() {
        // Default constructor for JPA
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // --- Getters and Setters ---
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // --- toString() method for easy logging and debugging ---
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}