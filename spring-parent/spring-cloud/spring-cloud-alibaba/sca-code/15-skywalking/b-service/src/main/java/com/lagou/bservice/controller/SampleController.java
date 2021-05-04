package com.lagou.bservice.controller;

import com.lagou.bservice.feignclient.CServiceFeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;

@Controller
public class SampleController {
    @Resource
    private CServiceFeignClient cService;
    @GetMapping("/b")
    @ResponseBody
    public String methodB(){
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = cService.methodC();
        result = " -> Service B" + result;
        return result;
    }
}
