package org.example;

public class OnlinePaymentNotification extends PaymentNotification{
    private final String paymentMethod;

    public OnlinePaymentNotification(NotificationChannel channel, double amount, String paymentMethod){
        super(channel, amount);
        if (paymentMethod == null || paymentMethod.isBlank()) {
            throw new IllegalArgumentException("Payment method must not be empty");
        }
        this.paymentMethod = paymentMethod;
    }
    @Override
    public String buildMessage() {
        return String.format("Your online payment of $%.2f via %s was successful. Thank you for your order!",
                amount, paymentMethod);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
