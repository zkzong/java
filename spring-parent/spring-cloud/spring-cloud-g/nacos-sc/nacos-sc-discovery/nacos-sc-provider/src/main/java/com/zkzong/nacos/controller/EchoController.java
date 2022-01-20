package com.zkzong.nacos.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EchoController {
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @PostMapping("echo1")
    public String echo1(@RequestParam String name) {
        return "echo, " + name;
    }

}
