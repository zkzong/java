package com.itheima.jvmoptimize.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zongz
 * @Date: 2024/6/27
 */
@RestController
@RequestMapping("/leak2")
public class LeakController2 {

    private Map<Long, Object> userCache = new HashMap<>();

    /**
     * 登录接口id，放入hashmap中
     *
     * @param id
     */
    @GetMapping("/login")
    public void login(Long id) {
        userCache.put(id, new byte[1024 * 1024 * 300]);
    }

    /**
     * 登出接口，删除缓存的用户信息
     *
     * @param id
     */
    @GetMapping("/logout")
    public void logout(Long id) {
        userCache.remove(id);
    }
}
