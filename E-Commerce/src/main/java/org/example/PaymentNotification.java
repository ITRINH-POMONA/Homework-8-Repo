package org.example;

public abstract class PaymentNotification {
    protected final NotificationChannel channel;
    protected final double amount;

    protected PaymentNotification(NotificationChannel channel, double amount) {
        if (channel == null) {
            throw new IllegalArgumentException("Channel must not be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }
        this.channel = channel;
        this.amount = amount;
    }
    public abstract String buildMessage();

    public String notifyCustomer(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Recipient must not be empty");
        }
        return channel.send(recipient, buildMessage());
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public double getAmount() {
        return amount;
    }
}
