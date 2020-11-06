package com.zkzong.sb2.controller;

import com.alibaba.fastjson.JSON;
import com.zkzong.sb2.model.JsonRootBean;
import com.zkzong.sb2.model.User;
import com.zkzong.sb2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
     *     "Request": {
     *         "action": "SMSArrived",
     *         "smsType": "1",
     *         "apiVersion": "2013-12-26",
     *         "content": "4121908f3d1b4edb9210f0eb4742f62c",
     *         "fromNum": "13912345678",
     *         "dateSent": "20130923010000",
     *         "deliverCode": "DELIVRD",
     *         "recvTime": "20130923010010",
     *         "status": "0",
     *         "reqId": "123",
     *         "smsCount": "2"
     *     }
     * }
     *
     * @param bean
     * @return
     */
    @RequestMapping(value = "request")
    public String request(@RequestBody JsonRootBean bean) {
        System.out.println(bean);
        return null;
    }
}
