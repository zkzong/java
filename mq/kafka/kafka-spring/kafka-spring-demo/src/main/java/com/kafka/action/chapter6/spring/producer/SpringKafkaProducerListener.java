package com.kafka.action.chapter6.spring.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * Description: 自定义一个Listener<br/>
 *
 * @author moudaen
 * @version 1.0
 * @date 2017年5月11日
 */
public class SpringKafkaProducerListener implements ProducerListener<String, String> {

    // private static final Logger LOG=
    // Logger.getLogger(SpringProducerListener.class);

    /**
     *
     */
    @Override
    public void onSuccess(String topic, Integer partition, String key,
                          String value, RecordMetadata recordMetadata) {
//		System.out.println("委托成功:主题[" + topic + "],分区["
//				+ recordMetadata.partition() + "],委托时间["+recordMetadata.timestamp()+"],委托信息如下：");
//		System.out.println(value);

    }

    @Override
    public void onError(String topic, Integer partition, String key,
                        String value, Exception e) {
        System.out.println("消息发送失败:topic:" + topic + ",value" + value
                + ",exception:" + e.getLocalizedMessage());
    }

    /**
     * 要onSuccess方法执行，需要返回true
     */
    @Override
    public boolean isInterestedInSuccess() {
        return true;
    }

}
