package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@DependsOn("rabbitmqReceiver")
public class RabbitmqSender {

    @Autowired
    private AmqpTemplate template;

    @PostConstruct
    void init(){
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> {
            send();
        }, 10, TimeUnit.SECONDS);
    }

    public void send(){
        String message = "message->" + new Date();
        template.convertAndSend("hello", message);
    }
}
