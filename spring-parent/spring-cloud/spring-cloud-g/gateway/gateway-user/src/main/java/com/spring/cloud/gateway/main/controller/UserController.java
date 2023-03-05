package com.spring.cloud.gateway.main.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info/{id}")
    public User info(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        user.setUserName("user_name");
        user.setNote("note");
        return user;
    }
}
