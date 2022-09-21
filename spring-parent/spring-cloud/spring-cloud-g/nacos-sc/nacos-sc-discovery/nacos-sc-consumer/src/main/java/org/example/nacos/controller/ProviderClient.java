package org.example.nacos.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zong
 * @Date: 2022/1/20
 */
@FeignClient("nacos-provider")
public interface ProviderClient {

    @PostMapping("echo1")
    String echo1(@RequestParam String name);

}
