package com.cognizant.ormlearn.service; // Matches the folder: src/main/java/com/cognizant/ormlearn/service

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.stereotype.Service;              // Marks this class as a Spring service
import org.springframework.transaction.annotation.Transactional; // For transaction management

import com.cognizant.ormlearn.model.Country;       // Import your Country entity
import com.cognizant.ormlearn.repository.CountryRepository; // Import your CountryRepository

@Service // Indicates that this class is a 'Service' component in the Spring application context
public class CountryService {

    @Autowired // Automatically injects an instance of CountryRepository
    private CountryRepository countryRepository;

    @Transactional(readOnly = true) // Ensures this read-only method runs within a transaction
    public List<Country> getAllCountries() {
        // Invokes the findAll() method provided by JpaRepository to retrieve all Country entities
        return countryRepository.findAll();
    }

    
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional(readOnly = true)
    public Country getCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }
}