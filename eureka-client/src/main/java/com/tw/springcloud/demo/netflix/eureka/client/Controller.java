package com.tw.springcloud.demo.netflix.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private DiscoveryClient client;

    @Value("${server.port:8080}")
    private int port;

    private volatile boolean delay = false;

    @RequestMapping("/")
    public String home() {
        List<String> services = client.getServices();
        services.forEach(name -> {
            System.out.println("---->" + name);
        });
        try {
            if(delay) {
                Thread.sleep(2000);
            }
            delay = !delay;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World" + port;
    }
}
