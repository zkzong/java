package com.zkzong.sj.controller;

import com.zkzong.sj.service.OtherService;
import com.zkzong.sj.service.ShardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableController {

    @Autowired
    private OtherService otherService;

    @Autowired
    private ShardingService shardingService;

    @RequestMapping(value = "/sharding")
    public String addSharding() {
        shardingService.addSharding();
        return "成功";
    }

    @RequestMapping(value = "/other")
    public String addOther() {
        otherService.addOther();
        return "成功";
    }
}
