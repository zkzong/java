package com.kafka.action.chapter6.spring.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * Description:消费者处理实例类 <br/>
 *
 * @author moudaen
 * @version 1.0
 * @date 2017年5月12日
 */
public class SpringKafkaConsumerListener implements MessageListener<String, String> {

    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        if (null != data) {// 当读取到用户委托信息后，将委托信息加入到委托队列中,然后由撮合程序完成撮合,这里我们只是简单的打印出委托信息
            System.out.println("消费者线程:" + Thread.currentThread().getName()
                    + ",消息来自Kafka,主题[" + data.topic() + "],分区["
                    + data.partition() + "],委托时间[" + data.timestamp()
                    + "]息内容如下：");
            System.out.println(data.value());
        }

    }

}
