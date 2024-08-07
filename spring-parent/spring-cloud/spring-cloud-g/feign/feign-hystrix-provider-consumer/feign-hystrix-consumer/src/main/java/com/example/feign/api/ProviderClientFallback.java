package com.example.feign.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class ProviderClientFallback implements ProviderClient {

    @RequestMapping("/provider/call")
    @Override
    public String call() {
        return "fallback fail";
    }

}
