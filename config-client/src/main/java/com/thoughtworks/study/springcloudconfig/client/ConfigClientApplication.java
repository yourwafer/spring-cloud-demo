package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class ConfigClientApplication {

    @Value("client-name")
    String serverName;

    @Value("${from:default-value---0}")
    String from;

    @Value("${encrpt}")
    String secret;

    @RequestMapping("/")
    public String home() {
        return from;
    }

    @RequestMapping("/name")
    public String name() {
        return serverName;
    }

    @RequestMapping("/secret")
    public String secret() {
        return secret;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}