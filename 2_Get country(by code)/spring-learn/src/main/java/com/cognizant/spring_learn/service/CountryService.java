package com.cognizant.spring_learn.service;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    /**
     * Retrieves a specific country from the list based on a case-insensitive code.
     * @param code The 2-letter country code.
     * @return The matching Country object, or null if not found.
     */
    public Country getCountry(String code) {
        LOGGER.info("START - getCountry({})", code);

        // Load the country list from country.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", ArrayList.class);

        // Use a lambda expression to find the matching country
        Country foundCountry = countries.stream()
            .filter(country -> country.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElse(null); // Return null if no country is found

        LOGGER.info("END - getCountry");
        return foundCountry;
    }
}
