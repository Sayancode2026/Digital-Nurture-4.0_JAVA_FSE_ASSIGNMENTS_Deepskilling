package com.example.document;

/**
 * Declares the interface for a type of document.
 * This interface defines the common operations that all concrete documents must implement.
 */
public interface Document {

    /**
     * Opens the document.
     */
    void open();

    /**
     * Closes the document.
     */
    void close();

    /**
     * Saves the document.
     */
    void save();
}