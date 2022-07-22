package com.zkzong.rabbit.controller;

import com.zkzong.rabbit.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private Producer producer;

    @RequestMapping("/send")
    public String send() {
        producer.send();
        return "send";
    }
}
