package com.example;

// JUnit 5 and Mockito imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * Test class for OrderService, demonstrating interaction verification with Mockito.
 * @ExtendWith(MockitoExtension.class) integrates Mockito with the JUnit 5 test lifecycle.
 */
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    // @Mock creates a mock implementation for the Notifier interface.
    @Mock
    private Notifier mockNotifier;

    // @InjectMocks creates an instance of OrderService and injects the mock Notifier.
    @InjectMocks
    private OrderService orderService;

    @Test
    public void testPlaceOrder_CallsNotifierWithCorrectArguments() {
        // 1. ARRANGE
        String testUser = "john.doe";
        long testOrderId = 12345L;
        String expectedMessage = "Your order #12345 has been confirmed.";

        // 2. ACT
        // Call the method we want to test.
        orderService.placeOrder(testUser, testOrderId);

        // 3. ASSERT (using Verification)
        // Verify that the sendNotification method on our mock was called exactly one time
        // with the specific arguments we expect.
        verify(mockNotifier, times(1))
            .sendNotification(testUser, expectedMessage);
            
        System.out.println("Verification successful: Notifier was called with the correct user and message.");
    }

    @Test
    public void testSomeOtherLogic_DoesNotCallNotifier() {
        // ARRANGE
        // No specific arrangement is needed.

        // ACT
        // Imagine we are testing a different method on OrderService that
        // should NOT trigger a notification. For this example, we don't call any method.
        // In a real test, you'd call that other method here.

        // ASSERT (using Verification)
        // Verify that the sendNotification method was NEVER called.
        // We use argument matchers (anyString()) because we care that the method
        // was never called, regardless of what the arguments might have been.
        verify(mockNotifier, never()).sendNotification(anyString(), anyString());

        System.out.println("Verification successful: Notifier was correctly NOT called.");
    }
}
