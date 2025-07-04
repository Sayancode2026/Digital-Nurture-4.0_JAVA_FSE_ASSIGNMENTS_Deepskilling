package com.example;

// JUnit 5 and Mockito imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test class for MyService, demonstrating behavior verification.
 * @ExtendWith(MockitoExtension.class) integrates Mockito with the JUnit 5 test lifecycle.
 */
@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    // @Mock creates a mock implementation for the ExternalApi interface.
    @Mock
    private ExternalApi mockApi;

    // @InjectMocks creates an instance of MyService and injects the mocks
    // that are created with @Mock into it.
    @InjectMocks
    private MyService myService;

    @Test
    public void testFetchData_CallsApiGetData() {
        // Arrange
        // We can still stub the return value for our state-based assertion later.
        String expectedData = "Mocked Data from API";
        when(mockApi.getData()).thenReturn(expectedData);

        // Act
        String actualData = myService.fetchData();

        // Assert (State testing)
        // First, we assert that the state (the return value) is correct.
        assertEquals(expectedData, actualData, "The returned data should match the stubbed data.");

        // Assert (Behavior verification)
        // Now, we verify the behavior: was the getData() method on our mock object
        // called exactly one time?
        verify(mockApi, times(1)).getData();

        // We can also verify that other methods were NOT called.
        verify(mockApi, never()).processData(anyString());
    }

    @Test
    public void testSendDataForProcessing_CallsApiProcessData() {
        // Arrange
        // No arrangement needed for this behavior test, as we are not checking a return value.

        // Act
        myService.sendDataForProcessing();

        // Assert (Behavior verification)
        // Verify that the processData method was called exactly once with the correct argument.
        verify(mockApi).processData("important payload"); // times(1) is the default

        // Verify that the getData method was never called during this interaction.
        verify(mockApi, never()).getData();
    }
}
