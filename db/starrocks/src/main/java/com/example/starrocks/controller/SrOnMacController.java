package com.example.starrocks.controller;

import com.example.starrocks.entity.SrOnMac;
import com.example.starrocks.service.SrOnMacService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/starrocks")
public class SrOnMacController {

    @Resource
    private SrOnMacService srOnMacService;

    @GetMapping("/list")
    public String list() {
        List<SrOnMac> list = srOnMacService.list();
        System.out.println(list);
        return "success";
    }

    @GetMapping("/save")
    public String save() {
        srOnMacService.save();
        return "success";
    }

}
