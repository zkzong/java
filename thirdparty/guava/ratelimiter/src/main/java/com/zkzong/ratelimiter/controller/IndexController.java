package com.zkzong.ratelimiter.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Zong
 * @Date: 2018/11/16
 */
@RestController
@Slf4j
public class IndexController {

    RateLimiter rateLimiter = RateLimiter.create(1);

    /**
     * 限流
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        System.out.println("等待时间" + rateLimiter.acquire());
        if (true) {
            log.info("当前时间：{}", System.currentTimeMillis());
            return "购买成功";
        }
        return "购买失败";
    }

    /**
     * 降级
     * tryAcquire(long timeout, TimeUnit unit)
     * 从RateLimiter 获取许可如果该许可可以在不超过timeout的时间内获取得到的话，
     * 或者如果无法在timeout 过期之前获取得到许可的话，那么立即返回false（无需等待）
     */
    @RequestMapping("/buy")
    public Object miao(int count, String code) {
        //判断能否在1秒内得到令牌，如果不能则立即返回false，不会阻塞程序
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            System.out.println("短期无法获取令牌，真不幸，排队也瞎排");
            return "失败";
        }
        if (true) {
            System.out.println("购买成功");
            return "成功";
        }
        System.out.println("数据不足，失败");
        return "失败";
    }

}
