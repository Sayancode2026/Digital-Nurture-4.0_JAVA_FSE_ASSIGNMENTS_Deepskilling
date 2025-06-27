package com.example;

/**
 * The class we want to test. It depends on an ExternalApi.
 */
public class MyService {

    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    /**
     * Fetches and returns data using the injected dependency.
     */
    public String fetchData() {
        // This method calls the dependency to get its data.
        return api.getData();
    }

    /**
     * Sends some data to be processed by the dependency.
     */
    public void sendDataForProcessing() {
        // This method calls the dependency to process some data.
        api.processData("important payload");
    }
}
