package org.example.sb3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public String get() {
        return "success";
    }

    @RequestMapping("/post")
    public String post() {
        return "success";
    }

}
