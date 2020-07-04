package com.kafka.action.chapter7.streams;

import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

/**
 * Description: transformation相关api应用<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class TransformationDemo {

    public static void aggregator() throws InterruptedException {
        // 构造实例化KafkaStreams对象的配置
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-countdd");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> textLine = builder.stream("streams-foo");// 构造一个KStream日志流

        // 2.过滤无效数据，这里按行读取，去掉空行
        KStream<String, String> filteredLine = textLine
                .filter(new Predicate<String, String>() {

                    @Override
                    public boolean test(String key, String value) {
                        // 过滤操作，将不满足条件的数据去掉，当返回为false表示将该条数据集过滤掉
                        if (StringUtils.isBlank(value)) {
                            return false;
                        }
                        return true;
                    }
                });

        // 经由filter处理后，去行空行，现在将每行进行解析，因为每行数据作为消息的Value不包括Key,所以这里用flatMapValues函数，以逗号分隔解析出每个单词放入到一个迭代器中,这里为了用groupByKey对单词统计，所以我们先将wordStream做一个map变换处理
        KStream<String, String> wordStream = filteredLine
                .flatMapValues(new ValueMapper<String, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(String value) {
                        return Arrays.asList(value.toLowerCase(
                                Locale.getDefault()).split(","));// 单词不区分大小写
                    }
                });

        //
        KStream<String, String> wordPairs = wordStream
                .map(new KeyValueMapper<String, String, KeyValue<String, String>>() {
                    @Override
                    public KeyValue<String, String> apply(String key,
                                                          String value) {
                        return new KeyValue<String, String>(value, value);
                    }
                });

        KGroupedStream<String, String> wordGroup = wordPairs.groupByKey();
        KTable<String, Long> words = wordGroup.count("wordddcount");
        KGroupedTable<String, Long> groupedTable = words.groupBy(new KeyValueMapper<String, Long, KeyValue<String, Long>>() {
            @Override
            public KeyValue<String, Long> apply(String key, Long value) {
                return new KeyValue<String, Long>(key, value);
            }
        });
        KTable<String, Long> max = groupedTable.aggregate(new Initializer<Long>() {

            @Override
            public Long apply() {
                return Long.MIN_VALUE;
            }
        }, new Aggregator<String, Long, Long>() {

            @Override
            public Long apply(String aggKey, Long value, Long aggregate) {
                System.out.println("ADD---------" + aggKey + "\t" + value + "\t" + aggregate);
                return value > aggregate ? value : aggregate;
            }
        }, new Aggregator<String, Long, Long>() {

            @Override
            public Long apply(String aggKey, Long value, Long aggregate) {
                System.out.println("ADD---------" + aggKey + "\t" + value + "\t" + aggregate);
                return value > aggregate ? value : aggregate;
            }
        }, "max1");

        max.print();
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();

        // usually the stream application would be running forever,
        // in this example we just let it run for some time and stop since the
        // input data is finite.
        Thread.sleep(5000L);

        streams.close();
    }

    /**
     * 变换操作应用demo
     *
     * @throws InterruptedException
     */
    public static void transformationTest() throws InterruptedException {
        // 构造实例化KafkaStreams对象的配置
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-count");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> textLine = builder.stream("streams-foo");// 构造一个KStream日志流

        // 2.过滤无效数据，这里按行读取，去掉空行
        KStream<String, String> filteredLine = textLine
                .filter(new Predicate<String, String>() {

                    @Override
                    public boolean test(String key, String value) {
                        // 过滤操作，将不满足条件的数据去掉，当返回为false表示将该条数据集过滤掉
                        if (StringUtils.isBlank(value)) {
                            return false;
                        }
                        return true;
                    }
                });

        // 经由filter处理后，去行空行，现在将每行进行解析，因为每行数据作为消息的Value不包括Key,所以这里用flatMapValues函数，以逗号分隔解析出每个单词放入到一个迭代器中,这里为了用groupByKey对单词统计，所以我们先将wordStream做一个map变换处理
        KStream<String, String> wordStream = filteredLine
                .flatMapValues(new ValueMapper<String, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(String value) {
                        return Arrays.asList(value.toLowerCase(
                                Locale.getDefault()).split(","));// 单词不区分大小写
                    }
                });

        //
        KStream<String, String> wordPairs = wordStream
                .map(new KeyValueMapper<String, String, KeyValue<String, String>>() {
                    @Override
                    public KeyValue<String, String> apply(String key,
                                                          String value) {
                        return new KeyValue<String, String>(value, value);
                    }
                });

        KGroupedStream<String, String> wordGroup = wordPairs.groupByKey();
        KTable<String, Long> words = wordGroup.count("wordcount");
        words.print();

        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();

        // usually the stream application would be running forever,
        // in this example we just let it run for some time and stop since the
        // input data is finite.
        Thread.sleep(5000L);

        streams.close();
    }

    public static void main(String[] args) throws InterruptedException {
        //transformationTest();
        aggregator();
    }
}
