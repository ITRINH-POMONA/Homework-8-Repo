package org.example;

public interface NotificationChannel {
    String send(String recipient, String message);

    String getChannelName();
}
