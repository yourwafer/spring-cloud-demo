package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.stereotype.Component;

@Component
public class FeignUserResourceFallback implements FeignUserResource {

    @Override
    public String requestHello() {
        return "this is a fallback method return";
    }
}
