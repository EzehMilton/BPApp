package com.milton.notify.service;

import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    public void notifyPatients(){
        System.out.println("Sending notification");
        checkBPAndGetTelNo();
        addToDB();
        sendNotification();
        System.out.println("Notification sent");
    }

    private void checkBPAndGetTelNo(){
        System.out.println("Number retrieved: 07747175959");
    }

    private void addToDB(){
        System.out.println("Added details to database...");
    }

    private void sendNotification(){
        System.out.println("Sending SMS to user....");
    }


}
