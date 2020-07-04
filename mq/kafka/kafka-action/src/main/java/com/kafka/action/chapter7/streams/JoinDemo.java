package com.kafka.action.chapter7.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Description: jon操作的demo<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class JoinDemo {

    /**
     * KStream 连接
     *
     * @throws InterruptedException
     */
    public static void kstreamJoin() throws InterruptedException {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "join-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        final Serde<String> stringSerde = Serdes.String();
        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> leftStream = builder.stream(stringSerde,
                stringSerde, "left-source");
        KStream<String, String> rightSteam = builder.stream(stringSerde,
                stringSerde, "right-source");
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
        while (true) {
            KStream<String, String> joinedStream = leftStream.leftJoin(rightSteam,
                    new ValueJoiner<String, String, String>() {
                        @Override
                        public String apply(String leftValue, String rightValue) {
                            return "left:" + leftValue + ", right:"
                                    + rightValue;
                        }
                    }, JoinWindows.of(TimeUnit.MINUTES.toMillis(5)),// 指定时间窗口为5分钟
                    Serdes.String(), Serdes.String(), Serdes.String());
            joinedStream.print();
            Thread.sleep(5000L);
        }
    }

    /**
     * Ktable连接
     *
     * @throws InterruptedException
     */
    public static void ktableJoin() throws InterruptedException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ktable-join-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        final Serde<String> stringSerde = Serdes.String();
        KStreamBuilder builder = new KStreamBuilder();
        KTable<String, String> leftTable = builder.table(stringSerde,
                stringSerde, "left-source", "ktable-join-left");
        KTable<String, String> rightTable = builder.table(stringSerde,
                stringSerde, "right-source", "ktable-join-right");
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
        while (true) {
            KTable<String, String> joinedTable = leftTable.join(rightTable, new ValueJoiner<String, String, String>() {

                @Override
                public String apply(String leftValue, String rightValue) {
                    return "left:" + leftValue + ", right:"
                            + rightValue;
                }
            });

            joinedTable.print();
            Thread.sleep(1000L);
        }
    }

    public static void kstreamJoinKTable() throws InterruptedException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "join-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        final Serde<String> stringSerde = Serdes.String();
        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> kstream = builder.stream(stringSerde,
                stringSerde, "left-source");
        KTable<String, String> ktable = builder.table(stringSerde,
                stringSerde, "right-source", "ktable-join-right");
        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();
        while (true) {

            KStream<String, String> joinedStream = kstream.leftJoin(ktable,
                    new ValueJoiner<String, String, String>() {
                        @Override
                        public String apply(String leftValue, String rightValue) {
                            return "left:" + leftValue + ", right:"
                                    + rightValue;
                        }
                    },
                    Serdes.String(), Serdes.String());
            joinedStream.print();
            Thread.sleep(5000L);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //kstreamJoin();
        //ktableJoin();
        kstreamJoinKTable();
    }
}
