package com.zkzong.rabbitmq.producer.controller;

import com.zkzong.rabbitmq.producer.direct.Producer1;
import com.zkzong.rabbitmq.producer.direct.Producer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2019.1.4
 */
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitController {

    @Autowired
    private Producer1 producer1;

    @Autowired
    private Producer2 producer2;

    @RequestMapping(value = "/direct1")
    public String direct1() {
        producer1.send2Queue1();
        return "direct1";
    }

    @RequestMapping(value = "/direct2")
    public String direct2() {
        producer2.send2Queue2();
        return "direct2";
    }
}
