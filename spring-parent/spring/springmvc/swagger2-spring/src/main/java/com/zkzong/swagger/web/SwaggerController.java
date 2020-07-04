package com.zkzong.swagger.web;

import com.zkzong.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zong on 2017/6/9.
 */
@Api(value = "SwaggerController", description = "Swagger控制器")
@RestController
@RequestMapping(value = "/swagger")
public class SwaggerController {
    @ApiOperation(value = "获取用户信息", notes = "根据id获取用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam("id") Long id) {
        User user = new User(1L, "zong", 30);
        return user.toString();
    }
}
