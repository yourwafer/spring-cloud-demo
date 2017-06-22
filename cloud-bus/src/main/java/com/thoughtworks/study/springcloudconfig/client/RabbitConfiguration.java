package com.thoughtworks.study.springcloudconfig.client;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue getQueue(){
        return new Queue("hello");
    }
}
