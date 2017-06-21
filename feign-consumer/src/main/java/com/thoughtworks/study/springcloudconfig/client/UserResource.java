package com.thoughtworks.study.springcloudconfig.client;

import org.springframework.web.bind.annotation.RequestMapping;

public interface UserResource {

    @RequestMapping("/")
    public String requestHello();
}
