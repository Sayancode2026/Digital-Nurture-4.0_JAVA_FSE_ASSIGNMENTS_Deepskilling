package com.example;

/**
 * A simple calculator class with basic arithmetic operations.
 * This is the class we want to test.
 */
public class Calculator {

    /**
     * Adds two integers together.
     * @param a The first integer.
     * @param b The second integer.
     * @return The sum of a and b.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first.
     * @param a The first integer (minuend).
     * @param b The second integer (subtrahend).
     * @return The result of the subtraction.
     */
    public int subtract(int a, int b) {
        return a - b;
    }
}
