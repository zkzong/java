package com.example.sb2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    /**
     * 上传多个文件
     *
     * @param files
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile[] files) {
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getSize());
        }
        return "success";
    }

}
