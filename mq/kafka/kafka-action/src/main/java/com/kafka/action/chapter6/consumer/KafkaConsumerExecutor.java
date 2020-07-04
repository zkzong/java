package com.kafka.action.chapter6.consumer;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:多线程消费者 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class KafkaConsumerExecutor {

    public static void main(String[] args) {
        Map<String, Object> config = new HashMap<String, Object>();
        config.put("bootstrap.servers", "localhost:9092");
        config.put("group.id", "test"); //6个线程属于同一个消费组
        config.put("enable.auto.commit", true);// 显示设置位移自动提交
        config.put("auto.commit.interval.ms", 1000);// 设置位移提交时间间隔
        config.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        for (int i = 0; i < 6; i++) {
            new KafkaConsumerThread(config, "stock-quotation").start();
        }
    }
}
