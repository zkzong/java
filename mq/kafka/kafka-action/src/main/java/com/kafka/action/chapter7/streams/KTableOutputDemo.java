package com.kafka.action.chapter7.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;

import java.util.Properties;

/**
 * Description: Ktable操作的demo<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class KTableOutputDemo {

    /**
     * 创建KTable
     */
    public static void createKTable() throws InterruptedException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ktable-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();
        KTable<String, String> textLine = builder.table("left-source",
                "ktable-test");// 构造一个KTable更新流
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
        while (true) {

            textLine.print();

            Thread.sleep(5000L);
            //streams.close();
        }
    }

//	public static void createGroupTable() throws InterruptedException{
//		Properties props = new Properties();
//		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "KTable-test");
//		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
//				.getClass());
//		props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
//				.getClass());
//		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//		KStreamBuilder builder = new KStreamBuilder();
//		KTable<String, String> textLine = builder.table("streams-foo",
//				"KTable-test");// 构造一个KTable更新流
//		KGroupedTable<String, String> groupedTable = textLine.groupBy(new KeyValueMapper<String, String, KeyValue<String,String>>() {
//
//			@Override
//			public KeyValue<String, String> apply(String key, String value) {
//				return new KeyValue<String, String>(value, value);
//			}
//		});
//		KafkaStreams streams = new KafkaStreams(builder, props);
//		streams.start();
//		Thread.sleep(5000L);
//		streams.close();
//	}

    public static void convertTable2KStream() throws InterruptedException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ktable-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();
        KTable<String, String> textLine = builder.table("streams-foo",
                "ktable-test");// 构造一个KTable更新流
        KStream<String, String> stream = textLine.toStream();
        stream.print();
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
        Thread.sleep(5000L);
        streams.close();
    }

    public static void main(String[] args) throws InterruptedException {
        createKTable();
        //	convertTable2KStream();
    }
}
