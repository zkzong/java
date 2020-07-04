package com.kafka.action.chapter6.consumer;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description: <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class CommonConsumer {

    public static void main(String[] args) {
        // specify some consumer properties
        Properties props = new Properties();
        props.put("zookeeper.connect", "localhost:2181");
        props.put("zookeeper.connectiontimeout.ms", "100000");
        //props.put("group.id", "test_group");

        // Create the connection to the cluster
        ConsumerConfig consumerConfig = new ConsumerConfig(props);
        ConsumerConnector consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("stock-quotation-partition", 2);
        // create 4 partitions of the stream for topic “test”, to allow 4
        // threads to consume
        Map<String, List<KafkaStream<byte[], byte[]>>> topicMessageStreams = consumerConnector.createMessageStreams(map);
        List<KafkaStream<byte[], byte[]>> streams = topicMessageStreams.get("stock-quotation-partition");

        // create list of 4 threads to consume from each of the partitions
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // consume the messages in the threads
        for (final KafkaStream<byte[], byte[]> stream : streams) {
            executor.submit(new Runnable() {
                @Override
				public void run() {
                    for (MessageAndMetadata<byte[], byte[]> msgAndMetadata : stream) {
                        // process message (msgAndMetadata.message())
                        System.out.println("线程：" + Thread.currentThread().getName() + ",offset:" + msgAndMetadata.offset() + ",partition:" + msgAndMetadata.partition());
                        System.out.println("msg===============" + new String(msgAndMetadata.message()));
                    }
                }
            });
        }
    }
}
