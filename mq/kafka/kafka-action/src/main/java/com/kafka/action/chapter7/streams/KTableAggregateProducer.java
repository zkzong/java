package com.kafka.action.chapter7.streams;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * Description: 用于生产数据给KTable做聚合操作<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class KTableAggregateProducer {


    private static final Logger LOG = Logger.getLogger(KTableAggregateProducer.class);
    // 设置实例生产消息的总数
    private static final int MSG_SIZE = 5;
    // 主题名称
    private static final String TOPIC = "ktable-aggregate";
    // private static final String TOPIC = "stock-quotation-partition";
    // kafka集群
    private static final String BROKER_LIST = "127.0.0.1:9092";

    private static KafkaProducer<String, Integer> producer = null;

    static {
        // 1.构造用于实例化KafkaProducer的Properties信息
        Properties configs = initConfig();
        // 2.初始化一个KafkaProducer
        producer = new KafkaProducer<String, Integer>(configs);
    }

    /**
     * 初始化kafka配置
     *
     * @return
     */
    private static Properties initConfig() {
        Properties properties = new Properties();
        // kafka broker列表
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        // 设置序列化类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                IntegerSerializer.class.getName());
        return properties;
    }

    public static void main(String[] args) {

        ProducerRecord<String, Integer> record = null;
        try {
            for (int i = 0; i < MSG_SIZE; i++) {
                record = new ProducerRecord<String, Integer>(TOPIC, "KAKAF", 3);
                producer.send(record, new Callback() {

                    @Override
                    public void onCompletion(RecordMetadata metaData,
                                             Exception exception) {
                        if (null != exception) {// 发送异常记录异常信息
                            LOG.error("Send message occurs exception.",
                                    exception);
                        }
                        if (null != metaData) {
                            LOG.info(String.format("offset:%s,partition:%s",
                                    metaData.offset(), metaData.partition()));
                        }
                    }

                });
            }
        } catch (Exception e) {
            LOG.error("Send message occurs exception", e);
        } finally {
            producer.close();
        }
    }

}
