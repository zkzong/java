package com.zkzong.sb.upload.service.impl;

import com.zkzong.sb.upload.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public String upload(MultipartFile file) {
        // 判断是否为空文件
        if (file.isEmpty()) {
            return "上传文件不能为空";
        }

        // 文件类型
        String contentType = file.getContentType();
        // springmvc处理后的文件名
        String fileName = file.getName();
        log.info("服务器文件名：" + fileName);
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();

        // 保存文件
        // 可以使用二进制流直接保存
        // 这里直接使用transferTo
        try {
            file.transferTo(new File("d://okong-" + origFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.format(file.getClass().getName() + "方式文件上传成功！\n文件名:%s,文件类型:%s,文件大小:%s", origFileName, contentType, fileSize);
    }
}
