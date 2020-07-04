package com.zkzong.ack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManualAckApplicationTest {

    //@Autowired
    //private Producer producer;

    @Autowired
    private CallBackProducer callBackProducer;

    //@Test
    //public void produce() {
    //    //for (; ; ) {
    //        producer.send();
    //        try {
    //            Thread.sleep(300);
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    //}
    //}

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