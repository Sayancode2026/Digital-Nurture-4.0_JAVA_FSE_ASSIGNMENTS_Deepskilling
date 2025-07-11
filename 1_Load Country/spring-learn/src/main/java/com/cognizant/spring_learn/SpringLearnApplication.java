package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        // First, run our custom method to demonstrate XML bean loading
        displayCountry();

        // Then, start the main Spring Boot web application
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    /**
     * Loads the country.xml configuration, retrieves the 'country' bean,
     * and logs its details to the console.
     */
    public static void displayCountry() {
        LOGGER.info("START - displayCountry()");

        // 1. Create the ApplicationContext from the XML file on the classpath
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // 2. Retrieve the bean named "country" from the context
        Country country = context.getBean("country", Country.class);
        
        // 3. Log the retrieved country object
        LOGGER.info("Country : {}", country.toString());

        LOGGER.info("END - displayCountry()");
    }
}