package com.zkzong.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2016/9/13.
 * 在jsp中遍历Map数据
 */
@Controller
@RequestMapping("/iterMap")
public class IterMap {

    @RequestMapping(method = RequestMethod.GET)
    public String iterMap(ModelMap model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zong");
        map.put("age", 20);
        model.addAttribute("map", map);

        model.addAttribute("message", "Hello Spring MVC Framewrok!");

        return "itermap";
    }

}
