package com.zkzong.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zong on 2017/1/14.
 */
@Controller
@RequestMapping("/path")
public class PathVariableController {

//    @RequestMapping(value = "/{id}")
//    @ResponseBody
//    public String path(@PathVariable Integer id) {
//        return "id=" + id;
//    }

    @RequestMapping(value = "/{name}")
    public String pathPage(@PathVariable String name) {
        return "path";
    }
}
