package org.example.devtools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zong
 * @Date: 2018/8/28
 */
@RestController
public class DevToolsController {

    @GetMapping(value = "get")
    public String get() {
        return "get";
    }
}
