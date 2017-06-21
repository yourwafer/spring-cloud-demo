package com.thoughtworks.study.springcloudconfig.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback"/*, commandProperties = @HystrixProperty(name="circuitBreaker.forceOpen", value = "true")*/)
    public String requestClient() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://EUREKA-CLIENT-1", String.class);
        String body = forEntity.getBody();
        return body;
    }

    public String fallback() {
        return "this is the result of fallback method";
    }
}
