package com.example.sb.mybatis.controller;

import com.example.sb.mybatis.domain.Users;
import com.example.sb.mybatis.service.DynamicSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zongz
 * @Date: 2024/9/22
 */
@RestController
@RequestMapping("/dynamicsql")
public class DynamicSQLController {

    @Autowired
    private DynamicSQLService dynamicSQLService;

    @RequestMapping("/foreach")
    public String foreach(@RequestBody List<Long> ids) {
        dynamicSQLService.foreach(ids);
        return "success";
    }

    @RequestMapping("/where")
    public String where(@RequestBody Users users) {
        dynamicSQLService.where(users);
        return "success";
    }

    @RequestMapping("/trim")
    public String trim(@RequestBody Users users) {
        dynamicSQLService.trim(users);
        return "success";
    }

    @RequestMapping("/triminsert")
    public String triminsert(@RequestBody Users users) {
        dynamicSQLService.triminsert(users);
        return "success";
    }

    @RequestMapping("/bind")
    public String bind(@RequestParam Long id) {
        dynamicSQLService.bind(id);
        return "success";
    }

}
