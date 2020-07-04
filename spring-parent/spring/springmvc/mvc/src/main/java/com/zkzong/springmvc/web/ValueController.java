package com.zkzong.springmvc.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zong on 2017/3/10.
 */
@Controller
public class ValueController {
    // 加上static则mvc值为空
    @Value("${mvc}")
    private String mvc;

    @RequestMapping(value = "/value")
    @ResponseBody
    public String value() {
        return mvc;
    }
}
