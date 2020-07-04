package com.kafka.action.chapter6.consumer;

import com.kafka.action.chapter6.avro.AvroDeserializer;
import com.kafka.action.chapter6.avro.AvroStockQuotation;
import com.kafka.action.chapter6.avro.TopicEnum;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Properties;

/**
 * Description:Avro序列化与反序列化消费者 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class AvroQuotationConsumer {

    private static final Logger LOG = Logger
            .getLogger(AvroQuotationConsumer.class);

    private static final String BROKER_LIST = "127.0.0.1:9092, 172.117.12:9092, 172.117.12:9092, 172.117.12:9092";

    private static final String GROUP_ID = "avro-consumer";

    private static final Long TIME_OUT = 30L;

    private static KafkaConsumer<String, AvroStockQuotation> consumer = new KafkaConsumer<String, AvroStockQuotation>(
            initConfig());

    private static Properties initConfig() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                AvroDeserializer.class.getName());
        return props;
    }

    public void consume(String topicName) {
        try {
            if (null == consumer) {
                consumer = new KafkaConsumer<String, AvroStockQuotation>(
                        initConfig());
            }
            while (true) {
                consumer.subscribe(Collections.singletonList(topicName));
                ConsumerRecords<String, AvroStockQuotation> records = consumer
                        .poll(TIME_OUT);
                AvroStockQuotation quotation = null;
                if (null != records) {
                    for (ConsumerRecord<String, AvroStockQuotation> record : records) {
                        quotation = record.value();
                        LOG.info(String
                                .format("offset:%s,partition:%s,key:%s,value[stockCode%s,stockName%s]",
                                        record.offset(), record.partition(),
                                        record.key(), quotation.getStockCode(),
                                        quotation.getStockName()));
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Consume data from Kafka occurs exception", e);
        } finally {
            consumer.close();
            consumer = null;
        }
    }

    public static void main(String[] args) {
        AvroQuotationConsumer consumer = new AvroQuotationConsumer();
        while (true) {
            consumer.consume(TopicEnum.STOCK_QUOTATION_AVRO.getTopicName());
        }
    }
}
