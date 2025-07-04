package com.cognizant.ormlearn.repository; // Matches the folder: src/main/java/com/cognizant/ormlearn/repository

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country; // Import your Country entity

@Repository // Marks this interface as a Spring Data JPA repository component
public interface CountryRepository extends JpaRepository<Country, String> {
    // JpaRepository provides standard CRUD (Create, Read, Update, Delete) operations
    // <Country, String>: Country is the Entity type, String is the type of its primary key (co_code)
    // Spring Data JPA will automatically implement this interface at runtime.
}