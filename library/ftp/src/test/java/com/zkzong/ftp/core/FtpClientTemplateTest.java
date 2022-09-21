package org.example.ftp.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * todo 测试是否用到池
 * 测试ftp 上传，下载，删除
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FtpClientTemplateTest {

    @Autowired
    private FtpClientTemplate ftpTemplate;

    @Test
    public void uploadFileTest() {
        File file = new File("file/test.txt");
        boolean uploadResult = ftpTemplate.uploadFile(file, "/yyy");
        Assert.assertTrue(uploadResult);
    }


    @Test
    public void uploadFileThreadTest() {
        for (int i = 0; i < 100; i++) {
            Runnable runnable = () -> {
                File file = new File("file/test.txt");
                boolean uploadResult = ftpTemplate.uploadFile(file, "/");
                String threadName = Thread.currentThread().getName();
                System.out.println("Thread 1-" + threadName + ":" + uploadResult);
            };
            runnable.run();
            new Thread(runnable).start();

            Runnable runnable1 = () -> {
                File file = new File("file/test.txt");
                boolean uploadResult = ftpTemplate.uploadFile(file, "/");
                String threadName = Thread.currentThread().getName();
                System.out.println("Thread 2-" + threadName + ":" + uploadResult);
            };
            runnable1.run();
            new Thread(runnable1).start();
        }
    }


    @Test
    public void downloadFileTest() {
        boolean downloadResult = ftpTemplate.downloadFile("/", "test.txt", "E:\\");
        Assert.assertTrue(downloadResult);
    }

    @Test
    public void deleteFileTest() {
        boolean deleteResult = ftpTemplate.deleteFile("/", "test.txt");
        Assert.assertTrue(deleteResult);
    }

}
