package com.example.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "feign-provider", fallback = ProviderClientFallback.class)
public interface ProviderClient {

    @RequestMapping("/provider/call")
    String call();

}
