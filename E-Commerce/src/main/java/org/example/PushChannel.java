package org.example;

public class PushChannel implements NotificationChannel{
    @Override
    public String send(String recipient, String message){
        return "[Push to " + recipient + "] " + message;
    }

    @Override
    public String getChannelName(){
        return "Push";
    }
}
