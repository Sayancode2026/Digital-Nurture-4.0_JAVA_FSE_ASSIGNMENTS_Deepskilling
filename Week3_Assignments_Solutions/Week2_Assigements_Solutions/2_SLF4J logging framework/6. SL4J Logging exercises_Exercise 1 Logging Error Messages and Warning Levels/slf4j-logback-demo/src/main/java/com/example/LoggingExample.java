package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Java application demonstrating various logging levels using SLF4J.
 * The actual output depends on the Logback configuration.
 */
public class LoggingExample {

    // 1. Get a logger instance for the current class.
    // This is a static final variable, as the logger is thread-safe and can be shared.
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        
        System.out.println("Demonstrating different SLF4J logging levels.");
        System.out.println("The output you see depends on the configuration in logback.xml.");
        System.out.println("----------------------------------------------------------");

        // 2. Log messages at different levels.

        // TRACE is for extremely detailed, fine-grained debugging.
        // This will be hidden by a default INFO or DEBUG level configuration.
        logger.trace("This is a TRACE message. Very granular detail.");

        // DEBUG is for detailed information useful for developers to debug the application.
        // This will be hidden by a default INFO level configuration.
        logger.debug("This is a DEBUG message. For debugging purposes.");

        // INFO is for high-level events that mark the application's progress.
        logger.info("This is an INFO message. Application is running as expected.");

        // WARN indicates a potential problem or an unexpected event.
        // The application can continue, but it should be looked at.
        logger.warn("This is a WARN message. Something unexpected happened.");

        // ERROR indicates a serious problem that has occurred.
        // The application may not be able to continue.
        logger.error("This is an ERROR message. A failure has occurred.");
        
        // You can also log exceptions with error messages.
        // The stack trace will be automatically included in the log.
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("An exception occurred during calculation!", e);
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Logging demonstration finished.");
    }
}
