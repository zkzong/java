package org.example.http.controller;

import org.example.http.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2019.1.17
 */
@RestController
@RequestMapping(value = "/http")
public class HttpController {

    @RequestMapping(value = "form")
    public String form(String userName, Integer age) {
        System.out.println("userName=" + userName + ", age=" + age);
        return "success";
    }

    @RequestMapping(value = "json")
    public String json(@RequestBody User user) {
        System.out.println("user=" + user);
        return "success";
    }

}
