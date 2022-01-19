package com.zkzong.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("my-provider")
public interface ProviderApi {

    @RequestMapping("/echo1")
    public String echo1(@RequestParam String name);

}
