package org.example;

public class BitcoinPayment extends PaymentNotification{
    private final String walletAddress;

    public BitcoinPayment(NotificationChannel channel, double amount, String walletAddress) {
        super(channel, amount);
        if (walletAddress == null || walletAddress.isBlank()) {
            throw new IllegalArgumentException("Wallet address must not be empty");
        }
        this.walletAddress = walletAddress;
    }

    @Override
    public String buildMessage() {
        return String.format("Your Bitcoin payment of $%.2f from wallet %s has been received and confirmed.",
                amount, walletAddress);
    }

    public String getWalletAddress() {
        return walletAddress;
    }
}
