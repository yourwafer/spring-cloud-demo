package com.tw.springcloud.demo.netflix.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class ZuulClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulClientApplication.class, args);
    }

}