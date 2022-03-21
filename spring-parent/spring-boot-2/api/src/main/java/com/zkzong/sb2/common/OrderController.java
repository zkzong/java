package com.zkzong.sb2.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2022/3/21
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("{id}")
    public Result getOrder(@PathVariable("id") Integer id) {
        if (id == null) {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }
        Result result = new Result(ResultCode.SUCCESS, null);
        return result;
    }

}
