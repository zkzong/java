package com.example.apollo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zong
 * @Date: 2021/10/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encrypt() {
        System.out.println("PWD: " + stringEncryptor.encrypt("zong"));
    }

    @Test
    public void decrypt() {
        System.out.println("mima: " + stringEncryptor.decrypt("YI6h4yAZUrqSYTLS0rXtSg=="));
    }

}
