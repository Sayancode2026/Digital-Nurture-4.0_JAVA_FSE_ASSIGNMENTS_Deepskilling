package com.example;

/**
 * An interface representing a dependency that can send notifications.
 * It doesn't return anything (void), so we can't test it by checking a return value.
 * We MUST use verification to test interactions with it.
 */
public interface Notifier {
    /**
     * Sends a notification to a specific user.
     * @param username The recipient of the notification.
     * @param message The message to send.
     */
    void sendNotification(String username, String message);
}
