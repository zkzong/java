package com.zkzong.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Zong on 2017/1/11.
 */
@Controller
@RequestMapping("/postparams")
public class PostParams {

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    @ResponseBody
    public String get1(@RequestParam String id) {
        return "id=" + id;
    }

    // Content-Type = application/x-www-form-urlencoded
    @RequestMapping(value = "/post1", method = RequestMethod.POST)
    @ResponseBody
    public String post1(@RequestParam String id) {
        return "id=" + id;
    }

    @RequestMapping(value = "/post2", method = RequestMethod.POST)
    @ResponseBody
    public String post2(@RequestParam String id, @RequestParam(defaultValue = "mohan") String name) {
        return "id=" + id + ",name=" + name;
    }
}
