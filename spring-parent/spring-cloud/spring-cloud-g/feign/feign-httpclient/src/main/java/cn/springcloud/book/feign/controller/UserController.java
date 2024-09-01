package cn.springcloud.book.feign.controller;

import cn.springcloud.book.feign.entity.UserRequest;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zongz
 * @Date: 2024/9/1
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    public String getUser(@SpringQueryMap UserRequest userRequest) {
        return userRequest.toString();
    }

}
