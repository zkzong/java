package com.example.consul.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("consul-provider")
public interface HelloService {
    @PostMapping(value = "/sayHello")
    String sayHello(@RequestParam("name") String name);
}
