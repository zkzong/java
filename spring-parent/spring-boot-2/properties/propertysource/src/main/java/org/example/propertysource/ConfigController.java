package com.example.propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private Configs configs;

    @GetMapping("get")
    public String get() {
        String username = configs.getUsername();
        String password = configs.getPassword();
        return "username = " + username + ", password = " + password;
    }
}
