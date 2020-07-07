package com.zkzong.dubbo.web.controller;

import com.zkzong.dubbo.web.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Zong on 2017/3/31.
 */
@Controller
public class ConsumerController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
//        return "consumer";
        return userFacade.queryUser().toString();
    }
}
