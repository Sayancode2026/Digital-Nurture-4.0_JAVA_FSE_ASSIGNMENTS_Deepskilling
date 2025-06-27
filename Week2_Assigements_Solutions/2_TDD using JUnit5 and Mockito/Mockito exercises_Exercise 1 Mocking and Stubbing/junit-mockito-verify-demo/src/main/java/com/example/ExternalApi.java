
package com.example;

/**
 * Represents an external dependency (e.g., a database, a web service).
 */
public interface ExternalApi {
    /**
     * Fetches some data from an external source.
     */
    String getData();

    /**
     * Sends data to an external source for processing.
     */
    void processData(String data);
}