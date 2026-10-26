package org.example;

public class SmsChannel implements NotificationChannel{
    @Override
    public String send(String recipient, String message){
        return "[SMS to " + recipient + "] " + message;
    }

    @Override
    public String getChannelName(){
        return "SMS";
    }
}
