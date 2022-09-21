package org.example.springboot.controller;

import org.example.springboot.bean.User;
import org.springframework.beans.factory.annotation.Value;
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

    @Value(value = "${roncoo.secret}")
    private String secret;

    @Value(value = "${roncoo.number}")
    private int number;

    @Value(value = "${roncoo.desc}")
    private String desc;

    @RequestMapping
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "get")
    public Map<String, Object> get(@RequestParam String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("secret", secret);
        map.put("number", number);
        map.put("desc", desc);
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
