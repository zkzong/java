package com.zkzong.sb2.rabbitmq;

import com.zkzong.sb2.rabbitmq.ack.CallBackProducer;
import com.zkzong.sb2.rabbitmq.ack.Producer;
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
public class AckTest {

    @Autowired
    private Producer producer;

    @Autowired
    private CallBackProducer callBackProducer;

    @Test
    public void produce() {
        //for (; ; ) {
        producer.send();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //}
    }

    @Test
    public void produceCallBack() {
        //for (; ; ) {
        callBackProducer.send();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //}
    }

}
