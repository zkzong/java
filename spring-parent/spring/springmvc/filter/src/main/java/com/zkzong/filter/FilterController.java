package com.zkzong.filter;

import com.zkzong.filter.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zong on 17/1/12.
 */
@Controller
@RequestMapping("/filter")
public class FilterController {

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String testGet(String id, String name, @RequestBody UserInfo userInfo) {
        return "id=" + id + ", name=" + name + ", sex=" + userInfo.getSex() + ", age=" + userInfo.getAge();
    }

}
