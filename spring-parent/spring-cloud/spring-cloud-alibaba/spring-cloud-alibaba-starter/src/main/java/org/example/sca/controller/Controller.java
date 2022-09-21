package org.example.sca.controller;

import com.google.gson.Gson;
import org.example.sca.dto.User;
import org.springframework.web.bind.annotation.*;

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
