package org.example.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.*;
import org.example.oss.config.OssProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: zongz
 * @Date: 2024/10/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OssApplicationTest {

    @Autowired
    private OSS ossClient;
    @Autowired
    private OssProperties ossProperties;

    private String key;

    private File file;

    @Before
    public void init() {
        key = "test/baidu.png";

        String path = this.getClass().getClassLoader().getResource("").getPath();
        file = new File(path + "/baidu.png");
    }

    @Test
    public void putObject() {
        PutObjectResult putObjectResult = ossClient.putObject(ossProperties.getBucketName(), key, file);
        System.out.println(putObjectResult);
    }

    @Test
    public void uploadFile() throws Throwable {
        UploadFileRequest uploadFileRequest = new UploadFileRequest(ossProperties.getBucketName(), key);
        uploadFileRequest.setUploadFile(file.getAbsolutePath());
        UploadFileResult uploadFileResult = ossClient.uploadFile(uploadFileRequest);
        System.out.println(uploadFileResult);
    }

    @Test
    public void getObject() {
        OSSObject object = ossClient.getObject(ossProperties.getBucketName(), key);
        System.out.println(object);
    }

    @Test
    public void downloadFile() throws Throwable {
        DownloadFileRequest downloadFileRequest = new DownloadFileRequest(ossProperties.getBucketName(), key);
        downloadFileRequest.setDownloadFile("a.txt");
        DownloadFileResult downloadFileResult = ossClient.downloadFile(downloadFileRequest);
        System.out.println(downloadFileResult);
    }

    private Date date;

    @Before
    public void setDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        date = calendar.getTime();
    }

    @Test
    public void generatePresignedUrl() {
        URL url = ossClient.generatePresignedUrl(ossProperties.getBucketName(), key, date);
        System.out.println(url);
    }

    @Test
    public void generatePresignedUrlcontentType() {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(ossProperties.getBucketName(), key);
        generatePresignedUrlRequest.setExpiration(date);
        ResponseHeaderOverrides responseHeaderOverrides = new ResponseHeaderOverrides();
        String contentType = MediaTypeFactory.getMediaType(key).orElse(MediaType.APPLICATION_OCTET_STREAM).toString();
        // 当需要在浏览器里直接下载时，设置content-type为application/octet-stream，浏览器会直接下载文件，而不是打开文件
        responseHeaderOverrides.setContentType(contentType.toUpperCase());
        generatePresignedUrlRequest.setResponseHeaders(responseHeaderOverrides);
        URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
        System.out.println(url);
    }

}