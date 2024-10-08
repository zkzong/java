package org.example.oss;

import com.aliyun.oss.OSS;
import org.example.oss.config.OssProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
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

    @Before
    public void init() {
        key = "test/baidu.png";
    }

    @Test
    public void putObject() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        File file = new File(path + "/baidu.png");
        ossClient.putObject(ossProperties.getBucketName(), key, file);
    }

    @Test
    public void generatePresignedUrl() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date date = calendar.getTime();
        ossClient.generatePresignedUrl(ossProperties.getBucketName(), key, date);
    }

}