package com.example.nacos.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zong
 * @Date: 2022/1/20
 */
@FeignClient("nacos-provider")
public interface ProviderClient {

    @GetMapping("/feign/get")
    String get();

    @PostMapping("/feign/post")
    String post(@RequestParam String name);

}
