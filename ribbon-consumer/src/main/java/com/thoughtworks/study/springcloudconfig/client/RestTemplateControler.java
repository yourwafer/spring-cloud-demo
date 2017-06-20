package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class RestTemplateControler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String requestClient(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://EUREKA-CLIENT-1", String.class);
        String body = forEntity.getBody();
        return body;
    }
}
