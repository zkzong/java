package com.example.sb2.rabbitmq;

import com.example.sb2.rabbitmq.amqp.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: zong
 * @Date: 2021/8/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SenderTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello() {
        sender.send();
    }

}
