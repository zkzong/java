package org.example.eureka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EchoController {

    @GetMapping("/echo")
    public String echo(HttpServletRequest request) {
        return "echo: " + request.getParameter("name");
    }

    @RequestMapping("/echo1")
    public String echo1(@RequestParam String name) {
        return "echo: " + name;
    }

}
