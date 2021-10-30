package com.zkzong.apollo.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zong
 * @Date: 2019/3/2
 */
@RestController
public class JasyptController {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get")
    public String get() {
        String encrypt = stringEncryptor.encrypt("zong");
        System.out.println(configInfo);
        return encrypt;
    }
}
