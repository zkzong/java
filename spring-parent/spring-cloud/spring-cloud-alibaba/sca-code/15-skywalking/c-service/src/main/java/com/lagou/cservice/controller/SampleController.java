package com.lagou.cservice.controller;

import com.lagou.cservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
public class SampleController {
    @Resource
    private UserService userService;
    @GetMapping("/c")
    public String methodC(){
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = " -> Service C : Users=" + userService.selectAllUser().size();

        return result;
    }
}
