package com.lagou.cservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SampleController {
    @GetMapping("/c")
    public String methodC(){
        String result = " -> Service C";
        return result;
    }
}
