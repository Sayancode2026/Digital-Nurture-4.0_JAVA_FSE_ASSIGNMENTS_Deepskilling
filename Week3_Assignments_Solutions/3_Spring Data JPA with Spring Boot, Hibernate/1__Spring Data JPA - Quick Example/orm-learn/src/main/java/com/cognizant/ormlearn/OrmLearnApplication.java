package com.cognizant.ormlearn; // Matches the folder: src/main/java/com/cognizant/ormlearn

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext; // For managing application context

import com.cognizant.ormlearn.model.Country;       // Import your Country entity
import com.cognizant.ormlearn.service.CountryService; // Import your CountryService

@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, @ComponentScan
public class OrmLearnApplication {

    // Logger for logging messages
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    // Static reference to CountryService to be used in the static main method
    private static CountryService countryService;

    public static void main(String[] args) {
        LOGGER.info("Starting Spring Application...");

        // Run the Spring Boot application and get the application context
        ConfigurableApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Spring ApplicationContext loaded successfully.");

        // Retrieve the CountryService bean from the context
        // Spring's IoC container will inject CountryRepository into CountryService
        countryService = context.getBean(CountryService.class);
        LOGGER.info("CountryService bean retrieved.");

        // Call the test method to fetch and display countries
        testGetAllCountries();

        // Close the application context to ensure proper shutdown of resources
        context.close();
        LOGGER.info("Spring Application finished.");
    }

    /**
     * Test method to retrieve and log all countries from the database.
     */
    private static void testGetAllCountries() {
        LOGGER.info("Start: testGetAllCountries()");
        // Call the service method to get the list of countries
        List<Country> countries = countryService.getAllCountries();
        // Log the retrieved countries (using debug level as configured in application.properties)
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End: testGetAllCountries()");
    }
}