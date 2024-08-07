package com.example.executor.controller;

import com.example.executor.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutorController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async() {
        asyncService.executeAsync();
    }
}
