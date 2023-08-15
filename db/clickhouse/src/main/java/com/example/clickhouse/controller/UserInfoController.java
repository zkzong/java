package com.example.clickhouse.controller;

import com.example.clickhouse.pojo.UserInfo;
import com.example.clickhouse.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/selectById/{id}")
    public UserInfo selectById(@PathVariable("id") Integer id) {
        return userInfoService.selectById(id);
    }

    @PostMapping("/saveData")
    public void saveData(@RequestBody UserInfo userInfo) {
        userInfoService.saveData(userInfo);
    }

    @GetMapping("/selectList")
    public List<UserInfo> selectList() {
        return userInfoService.selectList();
    }
}
