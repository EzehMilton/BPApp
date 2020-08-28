package com.milton.notify.task;

import com.milton.notify.service.NotifyService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    NotifyService notifyService;

    public ScheduledTasks(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    // run once a day. 86400000
    @Scheduled(fixedRate = 5000)
    public void sendNotificationToPatienter(){
        // have a service class that calls an API
        // to get high BPS.
        // and gets tel number of such patients
        // then send a note to them
        notifyService.notifyPatients();
        System.out.println("Your blood pressure is high, seek assistance");
    }

}
