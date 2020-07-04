package com.zkzong.sb2.controller;

import com.alibaba.fastjson.JSON;
import com.zkzong.sb2.model.JsonRootBean;
import com.zkzong.sb2.model.User;
import com.zkzong.sb2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.11.18
 */
@RestController
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "findAll")
    public String findAll() {
        List<User> userList = userService.findAll();
        String userStr = JSON.toJSONString(userList);
        return userStr;
    }

    @RequestMapping(value = "request")
    public String request(@RequestBody JsonRootBean bean) {
        System.out.println(bean);
        return null;
    }
}
