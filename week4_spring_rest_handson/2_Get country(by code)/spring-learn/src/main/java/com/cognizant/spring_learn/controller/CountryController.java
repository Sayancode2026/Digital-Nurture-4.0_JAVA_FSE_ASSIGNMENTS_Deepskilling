package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // Spring will inject an instance of CountryService here
    @Autowired
    private CountryService countryService;

    /**
     * Handles GET requests for "/country".
     * This is the old method, which we can keep or remove.
     * For this example, we will keep it.
     */
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");
        // Note: This method still loads its own context, which is inefficient
        // but kept for consistency with the previous exercise.
        return countryService.getCountry("IN");
    }

    /**
     * Handles GET requests for "/countries/{code}", where {code} is a dynamic value.
     * @param code The country code passed in the URL.
     * @return The matching Country object as JSON.
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry with code: {}", code);
        return countryService.getCountry(code);
    }
}