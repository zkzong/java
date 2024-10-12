package com.example.sb.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zongz
 * @Date: 2024/10/10
 */
@RestController
@RequestMapping("/update")
public class UpdateController {

    @RequestMapping("/update")
    public Integer update() {
        return 0;
    }

    @RequestMapping("/updateRows")
    public Integer updateRows() {
        return 0;
    }
}
