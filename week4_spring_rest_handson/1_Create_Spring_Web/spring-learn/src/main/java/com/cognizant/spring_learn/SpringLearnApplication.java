package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    // Initialize a logger for this class
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        // Log a message to indicate the start of the main method
        LOGGER.info("STARTING THE APPLICATION");

        // This line bootstraps and launches the Spring application
        SpringApplication.run(SpringLearnApplication.class, args);

        // Log a message to indicate the application has finished starting
        LOGGER.info("APPLICATION STARTED SUCCESSFULLY");
    }
}
