package com.example.sb.mybatis.controller;

import com.example.sb.mybatis.domain.Users;
import com.example.sb.mybatis.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 插入后返回主键id
 *
 * @Author: zongz
 * @Date: 2024/9/24
 */
@RestController
@RequestMapping("/id/insert")
public class IdController {

    @Autowired
    private IdService idService;

    @RequestMapping("/useGeneratedKeys")
    public int insertUseGeneratedKeys(Users users) {
        return idService.useGeneratedKeys(users);
    }

    @RequestMapping("/selectkey")
    public int insertselectkey(Users users) {
        return idService.insertselectkey(users);
    }

    @RequestMapping("/selectKey")
    public int insertSelectKey(Users users) {
        return idService.insertSelectKey(users);
    }

    @RequestMapping("/options")
    public int insertOptions(Users users) {
        return idService.insertOptions(users);
    }

}
