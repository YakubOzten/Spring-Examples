package com.yakubozten.listener;

import com.yakubozten.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {


    @RabbitListener(queues = "yakub-ozten-queue")
    public  void handleMessage(Notification notification){
        System.out.println("Message received");
        System.out.println(notification.toString());
    }
}
