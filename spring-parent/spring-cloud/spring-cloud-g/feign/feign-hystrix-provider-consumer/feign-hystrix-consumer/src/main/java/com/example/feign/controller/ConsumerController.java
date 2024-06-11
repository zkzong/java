package com.example.feign.controller;

import com.example.feign.api.ProviderClient;
import com.example.feign.api.ProviderClient2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    @Autowired
    private ProviderClient2 providerClient2;

    @RequestMapping("/call")
    public String call() {
        return providerClient.call();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/fallbackMethod")
    public String fallbackMethod() {
        providerClient2.call();
        return "success";
    }

    public String fallback() {
        return "fallbackMethod";
    }

}
