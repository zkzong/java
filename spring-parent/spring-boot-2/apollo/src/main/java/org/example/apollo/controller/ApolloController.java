package org.example.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: Zong
 * @Date: 2019/3/2
 */
@RestController
public class ApolloController {

    @Value("${config.info:1}")
    private String configInfo;

    @Value("${config.startDate:2022-12-01}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date configStartDate;
    @Value("${config.endDate:2023-02-01}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date configEndDate;

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo() {
        return configInfo;
    }

    @GetMapping("/api")
    public void api() {
        // 默认命名空间
        Config appConfig = ConfigService.getAppConfig();
        String configInfo = appConfig.getProperty("config.info", "");
        System.out.println(configInfo);

        // 公共命名空间
        Config publicConfig = ConfigService.getConfig("ns-public");
        String aaa = publicConfig.getProperty("aaa", "");
        System.out.println(aaa);

        // 私有命名空间
        Config privateConfig = ConfigService.getConfig("ns-private");
        String bbb = privateConfig.getProperty("bbb", "");
        System.out.println(bbb);
    }

    @GetMapping("/date")
    public void date() {
        System.out.println(configStartDate);
        System.out.println(configEndDate);
    }
}
