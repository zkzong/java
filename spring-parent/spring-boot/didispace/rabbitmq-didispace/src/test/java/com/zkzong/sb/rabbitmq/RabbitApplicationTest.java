package com.zkzong.sb.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zong on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitApplicationTest {
    @Autowired
    private Sender sender;

    @Test
    public void hello() {
        sender.send();
    }
}