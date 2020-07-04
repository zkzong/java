package com.zkzong.sb.logback.controller;

import com.zkzong.sb.logback.entity.User;
import com.zkzong.sb.logback.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public String getUsers() {
        String name = "zong";
        log.info("Controller查询参数name = {}", name);
        List<User> userList = userService.findUsersByName(name);
        log.info("查询到姓名为 {} 的用户：{}", name, userList);
        return "success";
    }

    @RequestMapping(value = "/err")
    public String err() {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            log.error("抛出异常：{}", e);
        }
        return "error";
    }
}
