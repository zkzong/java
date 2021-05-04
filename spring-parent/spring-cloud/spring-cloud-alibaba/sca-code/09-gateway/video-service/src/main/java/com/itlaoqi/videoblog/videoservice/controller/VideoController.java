package com.itlaoqi.videoblog.videoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    @GetMapping("/test")
    public String findById() {
        return "SUCCESS";
    }
}
