package com.example.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "feign-provider")
public interface ProviderClient2 {

    @RequestMapping("/provider/call")
    String call();

}
