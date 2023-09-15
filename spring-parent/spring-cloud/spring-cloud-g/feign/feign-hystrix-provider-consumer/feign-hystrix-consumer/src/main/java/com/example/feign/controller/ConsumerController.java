package com.example.feign.controller;

import com.example.feign.api.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    @RequestMapping("/call")
    public String call() {
        return providerClient.call();
    }

}
