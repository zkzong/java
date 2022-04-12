package com.zkzong.nacos.controller;

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
    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://nacos-provider/echo/" + str, String.class);
    }

    /**
     * 使用FeignClient调用
     *
     * @return
     */
    @GetMapping("/get")
    public String get() {
        String s = providerClient.echo1("zong");
        return s;
    }
}
