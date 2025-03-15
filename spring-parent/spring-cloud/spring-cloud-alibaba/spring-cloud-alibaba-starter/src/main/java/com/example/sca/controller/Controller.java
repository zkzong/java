package com.example.sca.controller;

import com.example.sca.dto.User;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/get")
    public String get() {
        return "Hello World";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name) {
        return name;
    }

    @PostMapping("/post/json")
    public String post(@RequestBody User user) {
        Gson gson = new Gson();
        String s = gson.toJson(user);
        return s;
    }

}
