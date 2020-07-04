package com.zkzong.sb.upload.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FileUploadServiceTest {

    @Autowired
    private FileUploadService fileUploadService;

    // todo 测试用例
    @Test
    public void upload() {
//        FileItem fileItem = new DiskFileItem(new File(""));
//        MultipartFile file = new CommonsMultipartFile()
//        fileUploadService.upload();
    }
}