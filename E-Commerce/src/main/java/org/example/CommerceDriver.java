package org.example;

public class CommerceDriver {
    public static void main(String[] args){
        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();
        NotificationChannel push = new PushChannel();

        // Part 1
        System.out.println(new OnlinePaymentNotification(email, 59.99, "Credit Card").notifyCustomer("alice@example.com"));
        System.out.println( new OnlinePaymentNotification(sms, 24.50, "PayPal").notifyCustomer("555-0101"));
        System.out.println(new CashOnDeliveryPayment(email, 32.00).notifyCustomer("bob@example.com"));
        System.out.println(new CashOnDeliveryPayment(sms, 18.75).notifyCustomer("555-0102"));

        // Part 2
        System.out.println(new BitcoinPayment(email, 120.00, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa").notifyCustomer("carol@example.com"));
        System.out.println(new BitcoinPayment(sms, 75.25, "3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy").notifyCustomer("555-0103"));

        // Part 3
        System.out.println(new OnlinePaymentNotification(push, 45.00, "Credit Card").notifyCustomer("device-token-abc123"));
        System.out.println(new CashOnDeliveryPayment(push, 15.00).notifyCustomer("device-token-def456"));
        System.out.println(new BitcoinPayment(push, 99.99, "bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq").notifyCustomer("device-token-ghi789"));
    }
}
