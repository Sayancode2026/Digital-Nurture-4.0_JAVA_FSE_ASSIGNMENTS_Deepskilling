package com.example;

// JUnit 5 imports
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TodoList, demonstrating AAA pattern and setup/teardown methods with JUnit 5.
 */
public class TodoListTest {

    private TodoList todoList;

    /**
     * SETUP method, annotated with @BeforeEach.
     * This method runs BEFORE each @Test method.
     * It's used to create a clean test fixture for every test.
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Executing @BeforeEach: Setting up a new TodoList...");
        // This ensures each test starts with a fresh, empty TodoList object.
        todoList = new TodoList();
    }

    /**
     * TEARDOWN method, annotated with @AfterEach.
     * This method runs AFTER each @Test method.
     * It's used to clean up resources.
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Executing @AfterEach: Tearing down...");
        // Clearing the object to ensure it can be garbage collected.
        todoList = null;
    }

    @Test
    public void testAddTask_IncreasesTaskCount() {
        System.out.println("--> Running testAddTask_IncreasesTaskCount");
        // Arrange: The 'todoList' is already arranged by the setUp() method.
        // We just need the input for our method.
        String newTask = "Learn JUnit 5";

        // Act: Perform the action we want to test.
        todoList.addTask(newTask);

        // Assert: Verify the outcome.
        assertEquals(1, todoList.getTaskCount(), "After adding one task, the count should be 1.");
    }

    @Test
    public void testAddTask_AddsTaskToList() {
        System.out.println("--> Running testAddTask_AddsTaskToList");
        // Arrange
        String newTask = "Write clean tests";

        // Act
        todoList.addTask(newTask);

        // Assert
        List<String> tasks = todoList.getTasks();
        assertTrue(tasks.contains(newTask), "The list should contain the new task.");
        assertEquals(1, tasks.size(), "The list should only contain one task.");
    }
    
    @Test
    public void testClearAll_RemovesAllTasks() {
        System.out.println("--> Running testClearAll_RemovesAllTasks");
        // Arrange: Add some tasks first to ensure the list is not empty.
        todoList.addTask("First Task");
        todoList.addTask("Second Task");
        assertEquals(2, todoList.getTaskCount(), "Pre-condition failed: List should have 2 tasks.");

        // Act: Call the method to be tested.
        todoList.clearAll();

        // Assert: Check that the list is now empty.
        assertEquals(0, todoList.getTaskCount(), "After clearing, task count should be 0.");
        assertTrue(todoList.getTasks().isEmpty(), "After clearing, the task list should be empty.");
    }

    @Test
    public void testAddTask_ThrowsExceptionForNullTask() {
        System.out.println("--> Running testAddTask_ThrowsExceptionForNullTask");
        // Arrange, Act, and Assert (for exceptions)
        // The assertThrows method checks that the action inside the lambda () -> {}
        // throws the specified exception class.
        assertThrows(IllegalArgumentException.class, () -> {
            todoList.addTask(null);
        }, "Adding a null task should throw an IllegalArgumentException.");
    }
}
