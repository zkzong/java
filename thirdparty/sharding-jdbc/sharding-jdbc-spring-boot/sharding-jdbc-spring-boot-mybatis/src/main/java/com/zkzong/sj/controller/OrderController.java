package com.zkzong.sj.controller;

import com.zkzong.sj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order")
    public String insert() {
        orderService.inertOrder();
        return "success";
    }
}
