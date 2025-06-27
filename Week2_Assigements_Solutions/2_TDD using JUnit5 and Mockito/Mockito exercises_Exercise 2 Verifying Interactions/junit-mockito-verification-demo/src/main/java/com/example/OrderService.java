package com.example;

/**
 * The class we want to test.
 * It processes orders and uses a Notifier to send a confirmation.
 */
public class OrderService {

    private final Notifier notifier;

    public OrderService(Notifier notifier) {
        this.notifier = notifier;
    }

    /**
     * Processes a new order and sends a confirmation notification.
     * @param username The user placing the order.
     * @param orderId The ID of the order.
     */
    public void placeOrder(String username, long orderId) {
        // Some internal logic would go here...
        
        // After successfully processing, send a notification.
        String message = "Your order #" + orderId + " has been confirmed.";
        notifier.sendNotification(username, message);
    }
}
