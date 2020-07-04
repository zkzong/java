package com.kafka.action.chapter7.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

/**
 * Description: Ktable简单操作<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class KTableTest {

    private static final Logger Log = Logger.getLogger(KTableTest.class);

    private static final String TOPIC = "ktable-test";

    public static void main(String[] args) {
        testKTable();
    }

    public void testKStream() {
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG,
                "ktable-test");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        streamsConfiguration.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG,
                "localhost:2181");
        streamsConfiguration.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes
                .String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes
                .String().getClass().getName());
        streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
                "earliest");
        streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG,
                "/tmp/state/kafka-streams");
        streamsConfiguration.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 1);
        // streamsConfiguration.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG,
        // cacheSizeBytes);
        // KTable<String, Long> table = builder.table(new StringSerde(),new
        // LongSerde(), TOPIC, "ktable-test");
        // KeyValue<String, Long> kv = KeyValue.pair("song", 1L);
        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> textLines = builder.stream(TOPIC);
        Log.info("--------------" + textLines
                + "=======================================");
        // Pattern pattern = Pattern.compile("\\W+",
        // Pattern.UNICODE_CHARACTER_CLASS);
        if (null != textLines) {
            KStream<String, Long> wordCounts = textLines
                    .flatMapValues(new ValueMapper<String, Iterable<String>>() {

                        @Override
                        public Iterable<String> apply(String value) {
                            return Arrays.asList(value.toLowerCase().split(
                                    "\\s+"));
                        }
                    })
                    .map(new KeyValueMapper<String, String, KeyValue<String, Long>>() {

                        @Override
                        public KeyValue<String, Long> apply(String key,
                                                            String value) {
                            return new KeyValue<String, Long>(value, 1L);
                        }
                    });
            wordCounts.writeAsText("/tmp/kafka-stream/stream.txt");
        }

        KafkaStreams streams = new KafkaStreams(builder, streamsConfiguration);
        streams.start();
    }

    public static void testKTable() {
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG,
                "ktable-test");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
                "server-1:9092,server-2:9092,server-3:9092");
        streamsConfiguration.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG,
                "server-1:2181,server-2:2181,server-3:2181");
        streamsConfiguration.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes
                .String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes
                .String().getClass().getName());
        streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
                "earliest");
        streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG,
                "/tmp/state/kafka-streams");
        streamsConfiguration.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 1);
        // streamsConfiguration.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG,
        // cacheSizeBytes);

        // KeyValue<String, Long> kv = KeyValue.pair("song", 1L);
        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> source = builder.stream(TOPIC);

        KTable<String, Long> counts = source
                .flatMapValues(new ValueMapper<String, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(String value) {
                        return Arrays.asList(value.toLowerCase(
                                Locale.getDefault()).split(" "));
                    }
                })
                .map(new KeyValueMapper<String, String, KeyValue<String, String>>() {
                    @Override
                    public KeyValue<String, String> apply(String key,
                                                          String value) {
                        return new KeyValue<>(value, value);
                    }
                }).groupByKey().count("ktable1-test");
        //counts.writeAsText("/tmp/kafka-stream/ktable.txt");
        //counts.writeAsText("/tmp/kafka-stream/ktable.txt", Serdes.String(), Serdes.Long());
        counts.to(Serdes.String(), Serdes.Long(), "streams-wordcount-output");
        KafkaStreams streams = new KafkaStreams(builder, streamsConfiguration);
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                streams.close();
            }
        }));
    }
}
