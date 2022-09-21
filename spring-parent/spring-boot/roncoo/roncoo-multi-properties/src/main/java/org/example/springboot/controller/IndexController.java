package org.example.springboot.controller;

import org.example.springboot.bean.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2017/1/21.
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "get")
    public Map<String, Object> get(@RequestParam String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("value", "hello world");
        return map;
    }

    @RequestMapping(value = "find/{id}/{name}")
    public User find(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        System.out.println(user.getDate());
        return user;
    }
}
