package com.zkzong.sb.upload.controller;

import com.zkzong.sb.upload.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: zkzong
 * @Date: 2018.9.20
 */
@RestController
@Slf4j
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) {
        fileUploadService.upload(file);
        return "success";
    }

}
