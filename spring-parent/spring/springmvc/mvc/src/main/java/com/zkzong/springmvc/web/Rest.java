package com.zkzong.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zong on 2017/3/31.
 */
@RestController
public class Rest {

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public String rest() {
        return "rest";
    }
}
