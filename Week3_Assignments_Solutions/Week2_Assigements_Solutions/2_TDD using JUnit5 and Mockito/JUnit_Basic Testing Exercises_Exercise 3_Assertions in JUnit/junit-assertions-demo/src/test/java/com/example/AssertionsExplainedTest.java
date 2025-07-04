package com.example;

// Imports for JUnit 5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class demonstrating various JUnit 5 assertion methods.
 * Each method is a self-contained test focusing on a specific assertion type.
 */
public class AssertionsExplainedTest {

    @Test
    public void testAssertEquals() {
        // This assertion checks if the expected value (5) is equal to the actual value (2 + 3).
        // In JUnit 5, the optional failure message is the last argument.
        assertEquals(5, 2 + 3, "Addition result should be 5");
    }

    @Test
    public void testAssertTrueAndFalse() {
        // Asserts that a condition is true.
        assertTrue(5 > 3, "5 should be greater than 3");
        
        // Asserts that a condition is false.
        assertFalse(5 < 3, "5 should not be less than 3");
    }

    @Test
    public void testAssertNullAndNotNull() {
        String nullString = null;
        String realString = "JUnit 5";

        // Asserts that an object is null.
        assertNull(nullString, "The string variable should be null");
        
        // Asserts that an object is not null.
        assertNotNull(realString, "The string variable should have been initialized");
    }

    @Test
    public void testAssertSameAndNotSame() {
        String originalString = "hello";
        String sameReference = originalString;
        String equalButDifferentObject = new String("hello");

        // assertEquals would pass for both, because the values are the same.
        assertEquals(originalString, sameReference);
        assertEquals(originalString, equalButDifferentObject);
        
        // assertSame checks for object identity (are they the same object in memory?).
        // This will pass.
        assertSame(originalString, sameReference, "These variables should refer to the same object");

        // This would fail if we used assertSame.
        // We use assertNotSame to prove they are different objects created in different memory locations.
        assertNotSame(originalString, equalButDifferentObject, "These variables should refer to different objects");
    }

    @Test
    public void testAssertArrayEquals() {
        char[] expected = {'J', 'u', 'n', 'i', 't'};
        char[] actual = "Junit".toCharArray();
        
        // This assertion is specifically for comparing the contents of arrays.
        // Using assertEquals(expected, actual) here would fail because they are two different array objects.
        assertArrayEquals(expected, actual, "The character arrays should have identical content");
    }
}
