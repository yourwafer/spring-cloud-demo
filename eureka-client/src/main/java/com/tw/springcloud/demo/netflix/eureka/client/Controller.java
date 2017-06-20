package com.tw.springcloud.demo.netflix.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/")
    public String home() {
        List<String> services = client.getServices();
        services.forEach(name -> {
            System.out.println("---->" + name);
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World";
    }
}
