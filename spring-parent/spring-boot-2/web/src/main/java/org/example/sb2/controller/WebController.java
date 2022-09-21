package org.example.sb2.controller;

import com.alibaba.fastjson.JSON;
import org.example.sb2.dto.A;
import org.example.sb2.dto.B;
import org.example.sb2.dto.JsonRootBean;
import org.example.sb2.entity.User;
import org.example.sb2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.11.18
 */
@RestController
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "findAll")
    public String findAll() {
        List<User> userList = userService.findAll();
        String userStr = JSON.toJSONString(userList);
        return userStr;
    }

    /**
     * 请求报文
     * {
     * "Request": {
     * "action": "SMSArrived",
     * "smsType": "1",
     * "apiVersion": "2013-12-26",
     * "content": "4121908f3d1b4edb9210f0eb4742f62c",
     * "fromNum": "13912345678",
     * "dateSent": "20130923010000",
     * "deliverCode": "DELIVRD",
     * "recvTime": "20130923010010",
     * "status": "0",
     * "reqId": "123",
     * "smsCount": "2"
     * }
     * }
     *
     * @param bean
     * @return
     */
    @RequestMapping(value = "request")
    public String request(@RequestBody JsonRootBean bean) {
        System.out.println(bean);
        return "success";
    }

    @RequestMapping(value = "ab")
    public String ab(@RequestBody A<B> ab) {
        System.out.println(ab);
        return "success";
    }

    /**
     * 入参是json串
     *
     * @param b
     * @return
     */
    @PostMapping(value = "b")
    public String b(@RequestBody B b) {
        System.out.println(b);
        return "success";
    }


    @PostMapping(value = "bb")
    public String bb(@RequestParam String name) {
        System.out.println(name);
        return "success";
    }
}
