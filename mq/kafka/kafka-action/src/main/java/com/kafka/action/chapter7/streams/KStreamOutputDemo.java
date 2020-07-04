package com.kafka.action.chapter7.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Properties;

/**
 * Description: KStream相关操作demo<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class KStreamOutputDemo {

    public static void createKStream() throws InterruptedException {
        // 构造实例化KafkaStreams对象的配置
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "KStream-test");// 指定流处理应用的id，该配置必须指定
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> textLine = builder.stream("streams-foo");// 构造一个KStream日志流
        textLine.print();// 输入日志流中数据
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
        Thread.sleep(5000L);// 让线程睡眠5秒
        streams.close();

    }

    public static void conver2KTable() throws InterruptedException {
        // 构造实例化KafkaStreams对象的配置
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "KStream-test");// 指定流处理应用的id，该配置必须指定
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> textLine = builder.stream("streams-foo");// 构造一个KStream日志流
        textLine.print();// 输入日志流中数据
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
        Thread.sleep(5000L);// 让线程睡眠5秒
        streams.close();
    }

    public static void main(String[] args) throws InterruptedException {
        //createKStream();
    }
}
