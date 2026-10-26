package org.example;

public class CashOnDeliveryPayment extends PaymentNotification {
    public CashOnDeliveryPayment(NotificationChannel channel, double amount) {
        super(channel, amount);
    }

    @Override
    public String buildMessage() {
        return String.format("Your order is confirmed. Please have $%.2f in cash ready upon delivery.", amount);
    }
}
