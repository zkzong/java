package org.example.multi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2022/1/15
 */
@RestController
public class EchoController {

    @GetMapping("/echo")
    public String echo(String name) {
        return "echo: " + name;
    }

    @GetMapping("/echo1")
    public String echo1(@RequestParam String name) {
        return "echo: " + name;
    }

}
