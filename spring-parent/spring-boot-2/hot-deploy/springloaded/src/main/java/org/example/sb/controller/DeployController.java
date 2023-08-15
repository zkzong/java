package com.example.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeployController {

    @GetMapping(value = "/say")
    public String say(HttpServletRequest request) {
        request.setAttribute("say", "Hello Imooc");
        return "imooc";
    }

}
