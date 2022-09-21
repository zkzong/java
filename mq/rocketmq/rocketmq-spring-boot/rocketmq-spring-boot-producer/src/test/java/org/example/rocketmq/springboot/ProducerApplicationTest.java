package org.example.rocketmq.springboot;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerApplicationTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${demo.rocketmq.topic}")
    private String springTopic;

    @Test
    public void producer() {
        String message = "test";
        rocketMQTemplate.syncSend(springTopic, message);
    }

}