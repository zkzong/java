package org.example.http.controller;

import com.alibaba.fastjson.JSON;
import org.example.http.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2019.1.17
 */
@RestController
@RequestMapping(value = "/http")
public class HttpController {

    // 请求url时拼接成 ?username=zong&age=30
    @GetMapping(value = "/get")
    public String get(String username, Integer age) {
        return "username = " + username + ", age = " + age;
    }

    /**
     * http://localhost:8080/getUser?params={"username":"zong","age":30}
     * postman可以，浏览器不可以
     *
     * @param params
     * @return
     */
    @GetMapping(value = "/getUser")
    public String getUser(String params) {
        User user = JSON.parseObject(params, User.class);
        return "username = " + user.getUsername() + ", age = " + user.getAge();
    }

    @PostMapping(value = "/post/form")
    public String form(String username, Integer age) {
        System.out.println("username=" + username + ", age=" + age);
        return "success";
    }

    @PostMapping(value = "/post/json")
    public String json(@RequestBody User user) {
        System.out.println("user=" + user);
        return "success";
    }

    /**
     * http://localhost:8080/postUser?params={"username":"zong","age":30}
     *
     * @param params
     * @return
     */
    @PostMapping(value = "/postUser")
    public String post(String params) {
        User user = JSON.parseObject(params, User.class);
        return "username = " + user.getUsername() + ", age = " + user.getAge();
    }

}
