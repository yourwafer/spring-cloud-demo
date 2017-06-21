package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("EUREKA-CLIENT-1")
public interface FeignRequestService {

    @GetMapping("/")
    public String rquestHello();
}
