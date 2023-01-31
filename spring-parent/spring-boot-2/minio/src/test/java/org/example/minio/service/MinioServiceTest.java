package org.example.minio.service;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MinioServiceTest {

    private String bucketName = "minio-example-demo";

    @Autowired
    private MinioService minioService;


    @Test
    public void bucketExists() {
        boolean b = minioService.bucketExists(bucketName);
        System.out.println(b);
    }

    @Test
    public void createBucket() {
        minioService.createBucket("test");
    }

    @Test
    public void getObject() {
        InputStream inputStream = minioService.getObject(bucketName, "简读中国史.jpg");
        FileUtil.writeFromStream(inputStream, "简读中国史.jpg");
    }

    @Test
    public void putObject() {
    }

    @Test
    public void testPutObject() {
    }

    @Test
    public void uploadFileSingle() {
    }

    @Test
    public void uploadFileBatch() {
    }

    @Test
    public void getUploadObjectUrl() {
    }

    @Test
    public void download() {
    }
}