package org.example;

public class EmailChannel implements NotificationChannel{
    @Override
    public String send(String recipient, String message){
        return "[Email to " + recipient + "] " + message;
    }

    @Override
    public String getChannelName(){
        return "Email";
    }
}
