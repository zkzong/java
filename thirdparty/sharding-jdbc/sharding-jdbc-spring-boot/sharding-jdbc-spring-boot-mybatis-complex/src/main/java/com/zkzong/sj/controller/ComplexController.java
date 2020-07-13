package com.zkzong.sj.controller;

import com.zkzong.sj.service.ShardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplexController {

    @Autowired
    private ShardingService shardingService;

    @RequestMapping(value = "/other")
    public String inertOther() {
        shardingService.inertOther();
        return "success";
    }

    @RequestMapping(value = "/sharding")
    public String inertSharding() {
        shardingService.inertSharding();
        return "success";
    }
}
