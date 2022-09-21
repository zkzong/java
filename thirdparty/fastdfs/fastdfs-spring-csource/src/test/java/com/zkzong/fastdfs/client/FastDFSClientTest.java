package org.example.fastdfs.client;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: zkzong
 * @Date: 2018.10.17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class FastDFSClientTest {

    private FastDFSClient fastDFSClient;

    @Before
    public void before() {
        fastDFSClient = new FastDFSClient();
    }

    @Test
    public void uploadFileWithFilepath() {
        String filePath = "../file/googlelogo.png";
        try {
            String path = fastDFSClient.uploadFileWithFilepath(filePath);
            System.out.println(path);
        } catch (FastDFSException e) {
            e.printStackTrace();
        }
    }
}