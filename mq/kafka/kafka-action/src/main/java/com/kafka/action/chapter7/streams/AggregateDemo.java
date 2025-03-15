package com.kafka.action.chapter7.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Properties;

/**
 * Description: 聚合操作<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class AggregateDemo {

    public static void aggregate4KStream2() {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "aggregate-kstream-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(StreamsConfig.POLL_MS_CONFIG, "10");

        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> stockInfo = builder.stream("stock-info");
        stockInfo
                .map(new KeyValueMapper<String, String, KeyValue<String, Integer>>() {
                    @Override
                    public KeyValue<String, Integer> apply(String key,
                                                           String value) {
                        // TODO Auto-generated method stub
                        return new KeyValue<String, Integer>(key, Integer.parseInt(value));
                    }
                })
                .groupByKey(Serdes.String(), Serdes.Integer())
                .aggregate(() -> Integer.MIN_VALUE,
                        (String key, Integer value, Integer aggregate) -> {
                            return value > aggregate ? value : aggregate;
                        }, Serdes.Integer(), "max").toStream().print();

        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
    }

    public static void aggregate4KStream() {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "aggregate-kstream-test2");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        //	props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(StreamsConfig.POLL_MS_CONFIG, "10");

        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> stockInfo = builder.stream("stock-info");
        stockInfo
                .map((key, value) -> {
                    return new KeyValue<String, Integer>(key, Integer
                            .parseInt(value));
                })
                .groupByKey(Serdes.String(), Serdes.Integer())
                .aggregate(() -> Integer.MIN_VALUE, (String key, Integer value, Integer aggregate) -> {
                    return value > aggregate ? value : aggregate;
                }, TimeWindows.of(60 * 1000L).advanceBy(60 * 1000L), Serdes.Integer(), "max2").toStream().print();
        //.aggregate(() -> Integer.MIN_VALUE, (String key,Integer value,Integer aggregate) ->{return  value > aggregate ? value : aggregate;}, UnlimitedWindows.of(), Serdes.Integer(), "max2").toStream().print();
//				.aggregate(() -> Integer.MIN_VALUE,
//						(String key, Integer value, Integer aggregate) -> {
//							return value > aggregate ? value : aggregate;
//						}, Serdes.Integer(), "max").toStream().print();

        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
    }

    public static void aggregate4KTable() {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ktable-aggregate-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.Integer()
                .getClass());// Value序列化与反序化类
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(StreamsConfig.POLL_MS_CONFIG, "10");

        KStreamBuilder builder = new KStreamBuilder();
        KTable<String, Integer> ktable = builder.table("ktable-aggregate",
                "ktable-aggregate-store");//指定值的类型为Integer
        ktable.groupBy((String key, Integer value) -> {
                    return new KeyValue<String, Integer>(key, value);
                }, Serdes.String(), Serdes.Integer())
                .aggregate(
                        () -> Integer.MIN_VALUE,
                        (key, value, aggregate) -> value > aggregate ? value
                                : aggregate,
                        (key, value, aggregate) -> value > aggregate ? value
                                : aggregate, "ktable-max").toStream().print();

        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();

    }

    public static void main(String[] args) {
        aggregate4KStream();
        //aggregate4KTable();
    }
}
