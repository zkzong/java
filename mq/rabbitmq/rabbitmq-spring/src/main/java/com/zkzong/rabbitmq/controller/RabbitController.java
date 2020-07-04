package com.zkzong.rabbitmq.controller;

import com.zkzong.rabbitmq.direct.sender.Sender1;
import com.zkzong.rabbitmq.direct.sender.Sender2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2019.1.4
 */
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitController {

    @Autowired
    private Sender1 sender1;

    @Autowired
    private Sender2 sender2;

    @RequestMapping(value = "/direct1")
    public String direct1() {
        sender1.send2Queue1();
        return "direct1";
    }

    @RequestMapping(value = "/direct2")
    public String direct2() {
        sender2.send2Queue2();
        return "direct2";
    }
}
