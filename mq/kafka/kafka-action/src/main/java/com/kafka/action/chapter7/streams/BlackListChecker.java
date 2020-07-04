package com.kafka.action.chapter7.streams;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;

import java.util.Date;
import java.util.Properties;

/**
 * Description: 接口防盗刷实例<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class BlackListChecker {

    /**
     * java8表达式
     */
    public static void checkBlackList2() {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ip-blacklist-checker");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(StreamsConfig.POLL_MS_CONFIG, "10");

        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> accessLog = builder.stream("access-log");
        accessLog.map((key, value) -> new KeyValue<>(value, value))
                .groupByKey().count(TimeWindows.of(60 * 1000L).advanceBy(60 * 1000), "access-count")//指定时间窗口为1分钟
                .toStream() //转为KStream
                .filter((Windowed<String> key, Long value) -> null != value && value >= 2)
                .process(() -> new IpBlackListProcessor());

        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();


    }

    /**
     * 实时计算黑名单
     */
    public static void checkBlackList() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ip-blacklist-checker");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Key序列化与反序化类
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String()
                .getClass());// Value序列化与反序化类
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(StreamsConfig.POLL_MS_CONFIG, "10");

        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> accessLog = builder.stream("access-log");
        accessLog.map(new KeyValueMapper<String, String, KeyValue<String, String>>() {//由于我们在写入数据时并没有设置Key，所以这里对每个数据集设置与Value相同的key
            @Override
            public KeyValue<String, String> apply(String key,
                                                  String value) {
                return new KeyValue<String, String>(value, value);
            }
        }).groupByKey().count(TimeWindows.of(60 * 1000L).advanceBy(60 * 1000), "access-count")//指定时间窗口为1分钟
                .toStream() //转为KStream
                .filter(new Predicate<Windowed<String>, Long>() {//从KStream中提取满足规则数据

                    @Override
                    public boolean test(Windowed<String> key, Long value) {//指定规则
                        System.out.println("请求时间：" + DateFormatUtils.format(new Date(System.currentTimeMillis()), "HH:mm:ss") + ",IP:" + key.key() + ",请求次数:" + value);
                        if (null != value && value.longValue() >= 2) {//这里为了测试，我们
                            return true;
                        }
                        return false;
                    }
                }).process(new ProcessorSupplier<Windowed<String>, Long>() {//处理命中的记录
            @Override
            public Processor<Windowed<String>, Long> get() {
                return new IpBlackListProcessor();//实例化自定义的Process对命中的记录进行处理
            }
        }, "access-count");

        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();

    }

    public static void main(String[] args) {
        checkBlackList();
    }
}
