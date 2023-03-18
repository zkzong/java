package com.spring.cloud.gateway.main.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/query")
    public User query(@RequestParam Integer id) {
        User user = new User();
        user.setId(id);
        user.setUserName("user_name");
        user.setNote("note");
        return user;
    }

    @RequestMapping("/insert")
    public User insert(@RequestBody User user) {
        User u = new User();
        u.setId(user.getId());
        u.setUserName(user.getUserName());
        u.setNote(user.getNote());
        return u;
    }
}
