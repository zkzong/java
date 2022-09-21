package org.example.http.controller;

import com.alibaba.fastjson.JSON;
import org.example.http.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping(value = "post")
    public String post(String name, int age) {
        return "name = " + name + ", age = " + age;
    }

    @PostMapping(value = "postUser")
    public String post(String params) {
        User user = JSON.parseObject(params, User.class);
        return "name = " + user.getName() + ", age = " + user.getAge();
    }

    // 请求url时拼接成 ?name=zong&age=30
    @GetMapping(value = "get")
    public String get(String name, int age) {
        return "name = " + name + ", age = " + age;
    }

    /**
     * http://localhost:8080/getUser?params={"name":"zong","age":30}
     * postman可以，浏览器不可以
     * @param params
     * @return
     */
    @GetMapping(value = "getUser")
    public String getUser(String params) {
        User user = JSON.parseObject(params, User.class);
        return "name = " + user.getName() + ", age = " + user.getAge();
    }
}
