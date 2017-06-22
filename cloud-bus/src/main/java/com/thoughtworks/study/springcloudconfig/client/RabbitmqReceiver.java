package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("rabbitmqReceiver")
@RabbitListener(queues = "hello")
public class RabbitmqReceiver {

    @RabbitHandler
    public void hand(String message) {
        System.out.println("receive message: [" + message + "] " + new Date());
    }
}
