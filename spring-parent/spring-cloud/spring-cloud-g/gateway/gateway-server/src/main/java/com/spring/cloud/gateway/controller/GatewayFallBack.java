package com.spring.cloud.gateway.controller;

import com.spring.cloud.gateway.pojo.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 定义降级服务
@RestController
@RequestMapping("/gateway")
public class GatewayFallBack {
    @GetMapping("/fallback")
    public ResultMessage fallback() {
        return new ResultMessage(false, "路由失败，请检查服务器状况");
    }
}
