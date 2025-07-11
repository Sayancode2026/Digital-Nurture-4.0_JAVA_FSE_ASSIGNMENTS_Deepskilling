package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController combines @Controller and @ResponseBody,
// indicating that this class will handle web requests and return data directly.
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    // Maps HTTP GET requests for "/hello" to this method.
    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START - sayHello()");
        LOGGER.info("END - sayHello()");
        return "Hello World!!";
    }
}