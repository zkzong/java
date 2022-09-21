package org.example.rabbit.delay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MQSenderTest {

    @Autowired
    private MQSender mqSender;

    @Test
    public void sendLazy() throws Exception {
        String msg = "hello spring boot";

        mqSender.sendLazy(msg + ":");
    }
}