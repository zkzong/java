package com.example.sb.upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String upload(MultipartFile file);
}
