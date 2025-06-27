package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class for managing a list of tasks.
 * This is the class we will test using the AAA pattern.
 */
public class TodoList {

    private List<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     * @param task The task description. Cannot be null or empty.
     */
    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty.");
        }
        tasks.add(task);
    }

    /**
     * @return The number of tasks in the list.
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * @return An unmodifiable view of the tasks list.
     */
    public List<String> getTasks() {
        return java.util.Collections.unmodifiableList(tasks);
    }

    /**
     * Removes all tasks from the list.
     */
    public void clearAll() {
        tasks.clear();
    }
}
