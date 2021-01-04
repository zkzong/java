package com.zkzong.idempotent.controller;

import com.zkzong.idempotent.annotation.ApiIdempotent;
import com.zkzong.idempotent.common.ServerResponse;
import com.zkzong.idempotent.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @ApiIdempotent
    @PostMapping("testIdempotence")
    public ServerResponse testIdempotence() {
        return testService.testIdempotence();
    }

}

