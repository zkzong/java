package com.kafka.action.chapter6.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

/**
 * Description:Kafka消费者相关Api应用<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class KafkaConsumerTest {

    /**
     * 订阅主题
     */
    public static void subscribe() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("client.id", "test");
        props.put("enable.auto.commit", true);// 显示设置位移自动提交
        props.put("auto.commit.interval.ms", 1000);// 设置位移提交时间间隔
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("stock-quotation"),
                new ConsumerRebalanceListener() {

                    @Override
                    public void onPartitionsRevoked(
                            Collection<TopicPartition> partitions) {
                        consumer.commitSync();// 提交位移
                    }

                    @Override
                    public void onPartitionsAssigned(
                            Collection<TopicPartition> partitions) {
                        long committedOffset = -1;
                        for (TopicPartition topicPartition : partitions) {
                            committedOffset = consumer
                                    .committed(topicPartition).offset();// 获取该分区已消费的位移
                            consumer.seek(topicPartition, committedOffset + 1);// 重置位移到上一次提交的位移处开始消费
                        }
                    }
                });

        // 订阅指定的分区
        // consumer.assign(Arrays.asList(new TopicPartition("stock-quotation",
        // 0),
        // new TopicPartition("stock-quotation", 2)));
        try {
            while (true) {
                // 等待拉取消息
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    // 简单打印出消息内容
                    System.out.printf(
                            "partition = %d, offset = %d,key= %s value = %s%n",
                            record.partition(), record.offset(), record.key(),
                            record.value());
                }
            }
        } catch (Exception e) {
            // TODO 异常处理
            e.printStackTrace();
        } finally {
            consumer.close();
        }

    }

    /**
     * 自动提交位移
     */
    public static void autoCommit() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("client.id", "test");
        props.put("enable.auto.commit", true);// 显示设置位移自动提交
        props.put("auto.commit.interval.ms", 1000);// 设置位移提交时间间隔
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅主题
        consumer.subscribe(Arrays.asList("stock-quotation"));

        try {
            while (true) {
                // 等待拉取消息
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    // 简单打印出消息内容
                    System.out.printf(
                            "partition = %d, offset = %d,key= %s value = %s%n",
                            record.partition(), record.offset(), record.key(),
                            record.value());
                }
            }
        } catch (Exception e) {
            // TODO 异常处理
            e.printStackTrace();
        } finally {
            consumer.close();
        }

    }

    /**
     * 手动提交位移
     */
    public static void manualCommit() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("client.id", "test");
        props.put("fetch.max.bytes", 1024);// 为了便于测试，这里设置一次fetch请求取得的records最大大小为1K,默认是5M
        props.put("enable.auto.commit", false);// 设置手动提交位移
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅主题
        consumer.subscribe(Arrays.asList("stock-quotation"));

        try {
            int minCommitSize = 10;// 最少处理10条消息后才进行提交
            int icount = 0;// 消息计算器
            while (true) {
                // 等待拉取消息
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    // 简单打印出消息内容,模拟业务处理
                    System.out.printf(
                            "partition = %d, offset = %d,key= %s value = %s%n",
                            record.partition(), record.offset(), record.key(),
                            record.value());
                    icount++;
                }
                // 在业务逻辑没有处理成功后提交位移
                if (icount >= minCommitSize) {
                    consumer.commitAsync(new OffsetCommitCallback() {

                        @Override
                        public void onComplete(
                                Map<TopicPartition, OffsetAndMetadata> offsets,
                                Exception exception) {
                            if (null == exception) {
                                // TODO 表示位移成功提交
                                System.out.println("提交成功");
                            } else {
                                // TODO 表示提交位移发生了异常，根据业务进行相关处理
                                System.out.println("发生了异常");
                            }
                        }
                    });
                    icount = 0; // 重设置计数器
                }
            }
        } catch (Exception e) {
            // TODO 异常处理
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    /**
     * postion用法测试
     */
    public static void position() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("client.id", "test");
        props.put("enable.auto.commit", true);// 显示设置位移自动提交
        props.put("auto.commit.interval.ms", 1000);// 设置位移提交时间间隔
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅主题
        consumer.assign(Arrays.asList(new TopicPartition("stock-quotation", 2)));
        TopicPartition partition = new TopicPartition("stock-quotation", 2);//构造待查询的分区
        try {
            long commitOffset = consumer.committed(partition).offset();
            long position = consumer.position(partition);
            System.out.println(commitOffset + "\t" + position);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    /**
     * 根据时间消费
     */
    public static void offsetsForTimes() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("client.id", "test");
        props.put("enable.auto.commit", true);// 显示设置位移自动提交
        props.put("auto.commit.interval.ms", 1000);// 设置位移提交时间间隔
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅主题
        consumer.assign(Arrays.asList(new TopicPartition("stock-quotation", 0)));
        try {
            Map<TopicPartition, Long> timestampsToSearch = new HashMap<TopicPartition, Long>();
            TopicPartition partition = new TopicPartition("stock-quotation", 0);//构造待查询的分区
            timestampsToSearch.put(partition,
                    (System.currentTimeMillis() - 12 * 3600 * 1000));// 设置查询12个小时之前消息的位移
            Map<TopicPartition, OffsetAndTimestamp> offsetMap = consumer
                    .offsetsForTimes(timestampsToSearch);// 会返回时间大于等于查找时间的第一个位移
            OffsetAndTimestamp offsetTimestamp = null;
            for (Map.Entry<TopicPartition, OffsetAndTimestamp> entry : offsetMap
                    .entrySet()) {//这里依然用for轮询，当然由于本例是查询的一个分区，因此也可以用if处理
                offsetTimestamp = entry.getValue();//若查询时间小于等于时间戳索引文件中最大记录索引时间，此时value为空,即待查询时间点之后没有新消息生成
                if (null != offsetTimestamp) {
                    System.out.printf("partition = %d, offset = %d,timestamp= %d%n",
                            entry.getKey().partition(), entry.getValue()
                                    .offset(), entry.getValue().timestamp());
                    consumer.seek(partition, entry.getValue().offset());// 重置消费起始位移
                }
            }
            while (true) {
                // 等待拉取消息
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    // 简单打印出消息内容
                    System.out.printf(
                            "partition = %d, offset = %d,key= %s value = %s%n",
                            record.partition(), record.offset(), record.key(),
                            record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    public static void main(String[] args) {
        subscribe();
        // manualCommit();
        //offsetsForTimes();
        //autoCommit();
        //position();
    }
}
