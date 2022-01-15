package com.zkzong.multi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zong
 * @Date: 2022/1/15
 */
@FeignClient("my-provider")
public interface ProviderClient {

    @GetMapping("/echo1")
    public String echo(String name);

}
