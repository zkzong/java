package com.example.log.controller;

import com.example.log.anno.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2022/3/9
 */
@RestController
public class TestController {

    @SysLog("测试")
    @GetMapping("/test")
    public String test(@RequestParam("name") String name) {
        return name;
    }
}
