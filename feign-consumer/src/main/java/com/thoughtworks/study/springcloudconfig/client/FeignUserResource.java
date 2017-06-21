package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "EUREKA-CLIENT-1", fallback = FeignUserResourceFallback.class)
public interface FeignUserResource extends UserResource {
}
