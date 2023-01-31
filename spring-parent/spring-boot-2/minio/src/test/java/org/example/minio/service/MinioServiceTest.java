package org.example.minio.service;

import cn.hutool.core.io.FileUtil;
import io.minio.ObjectWriteResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MinioServiceTest {

    private String bucketName = "minio-example-demo";

    @Autowired
    private HttpServletResponse httpServletResponse;

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
        ObjectWriteResponse objectWriteResponse = minioService.putObject(bucketName, "a.jpg", "D:/简读中国史.jpg");
        System.out.println(objectWriteResponse);
    }

    @Test
    public void testPutObject() {
        ObjectWriteResponse objectWriteResponse = minioService.putObject(bucketName, "aa.jpg", FileUtil.getInputStream("简读中国史.jpg"));
        System.out.println(objectWriteResponse);
    }

    @Test
    public void uploadFileSingle() {
        //minioService.uploadFileSingle(bucketName, new CommonsMultipartFile(new DiskFileItem()));
    }

    @Test
    public void uploadFileBatch() {
        //minioService.uploadFileBatch(bucketName, )
    }

    @Test
    public void getUploadObjectUrl() {
        String uploadObjectUrl = minioService.getUploadObjectUrl(bucketName, "简读中国史.jpg", 7);
        System.out.println(uploadObjectUrl);
    }

    @Test
    public void download() {
        minioService.download(bucketName, "简读中国史.jpg", httpServletResponse);
    }
}