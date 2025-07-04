package com.example;

// Import statements are different for JUnit 5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test class for the Calculator.
 * It uses JUnit 5 annotations and assertions.
 */
public class CalculatorTest {

    /**
     * A test case to verify the functionality of the add() method.
     * The @Test annotation now comes from org.junit.jupiter.api.Test
     */
    @Test
    public void testAdd() {
        // 1. Setup: Create an instance of the class we want to test.
        Calculator calculator = new Calculator();
        
        // 2. Execution: Call the method we are testing.
        int result = calculator.add(5, 3);
        
        // 3. Assertion: The assertEquals method now comes from org.junit.jupiter.api.Assertions
        // assertEquals(expected, actual)
        // The test will pass if result is 8, and fail otherwise.
        assertEquals(8, result);
        
        System.out.println("Test 'testAdd' completed successfully.");
    }

    /**
     * A test case for the subtract() method.
     * This demonstrates another simple test.
     */
    @Test
    public void testSubtract() {
        // Setup
        Calculator calculator = new Calculator();
        
        // Execution
        int result = calculator.subtract(10, 4);
        
        // Assertion
        assertEquals(6, result);

        System.out.println("Test 'testSubtract' completed successfully.");
    }
}
