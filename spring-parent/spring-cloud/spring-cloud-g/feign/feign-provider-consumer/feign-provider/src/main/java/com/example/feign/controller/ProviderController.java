package com.example.feign.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @RequestMapping("/call")
    public String call() {
        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }

}
