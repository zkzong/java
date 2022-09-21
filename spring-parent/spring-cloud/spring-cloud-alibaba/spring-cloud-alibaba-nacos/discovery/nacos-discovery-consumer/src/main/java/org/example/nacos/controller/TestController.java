package org.example.nacos.controller;

import org.example.nacos.api.EchoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2020/1/7
 */
@RestController
public class TestController {

    //private final RestTemplate restTemplate;

    //@Autowired
    //public TestController(RestTemplate restTemplate) {
    //    this.restTemplate = restTemplate;
    //}

    @Autowired
    private EchoClient echoClient;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        // 1. RestTemplate
        //return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
        // 2. FeignClient
        return echoClient.echo(str);
    }
}
