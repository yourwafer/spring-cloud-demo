package com.thoughtworks.study.springcloudconfig.client;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.LoggersEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class FeignConsumerApplication {

    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

}