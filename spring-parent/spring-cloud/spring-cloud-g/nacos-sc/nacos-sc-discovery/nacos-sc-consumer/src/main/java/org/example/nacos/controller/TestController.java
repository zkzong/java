package org.example.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderClient providerClient;

    /**
     * 使用restTemplate调用
     *
     * @param str
     * @return
     */
    @GetMapping(value = "/http/get/{str}")
    public String get(@PathVariable String str) {
        return restTemplate.getForObject("http://nacos-provider/http/get/" + str, String.class);
    }

    /**
     * 使用FeignClient调用
     *
     * @return
     */
    @GetMapping("/feign/get")
    public String get() {
        String s = providerClient.get();
        return s;
    }

    @PostMapping("/feign/post")
    public String post() {
        String s = providerClient.post("zong");
        return s;
    }
}
