package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    /**
     * Handles GET requests for "/country".
     * Loads the "country.xml" file, retrieves the "country" bean,
     * and returns it. Spring Boot automatically converts the Country object to JSON.
     * @return A Country object representing India.
     */
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");

        // 1. Create an ApplicationContext to load the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // 2. Retrieve the bean with the ID "country"
        Country country = context.getBean("country", Country.class);

        LOGGER.info("END - getCountryIndia()");
        
        // 3. Return the Country object
        return country;
    }
}
