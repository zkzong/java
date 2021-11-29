package com.zkzong.qdox.controller;

import com.zkzong.api.QdoxClient;
import com.zkzong.qdox.service.QdoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2021/11/25
 */
@RestController
public class QdoxController {

    @Autowired
    private QdoxService qdoxService;

    @Autowired
    private QdoxClient client;

    @RequestMapping("/qdox")
    public String qdox() {
        return qdoxService.getQdox();
    }

    @RequestMapping("/qdox")
    public String getName2() {
        return qdoxService.getName();
    }

    @RequestMapping("/name")
    public String getName() {
        return client.getName();
    }

}
