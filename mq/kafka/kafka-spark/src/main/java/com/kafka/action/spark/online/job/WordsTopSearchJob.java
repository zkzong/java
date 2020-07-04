package com.kafka.action.spark.online.job;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import scala.Tuple2;

import java.util.*;

/**
 * Description: 热搜词实例<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class WordsTopSearchJob {

    public static void main(String[] args) {

        // 1.事例化SparkConf,用于连接Spark
        SparkConf sparkConf = new SparkConf()
                .setAppName("kafka-sparkstreaming").setMaster("spark://server-1:7077");
        // 2. 事例化StreamingContext 实例，每10秒执行一次
        JavaStreamingContext streamContext = new JavaStreamingContext(sparkConf, new Duration(10000));
        // 3. 初始化Kafka消费者相关配置
        Map<String, Object> kafkaParams = initKafkaConsumerConf();

        // 4.指定计算中间结果存储在文件系统即HDFS中，对应hdfs://server-1:9000/words-top-search
        streamContext.checkpoint("/words-top-search");
        try {
            // 5. 订阅Kafka的"words-search"主题
            final JavaInputDStream<ConsumerRecord<String, String>> inputDStream = KafkaUtils
                    .createDirectStream(
                            streamContext,
                            LocationStrategies.PreferConsistent(),
                            ConsumerStrategies.<String, String>Subscribe(
                                    Arrays.asList("words-search"), kafkaParams));

            // 6. 将读取单词切分成元组
//			JavaPairDStream<String, String> words = inputDStream
//					.mapToPair(new PairFunction<ConsumerRecord<String, String>, String, String>() {
//
//						@Override
//						public Tuple2<String, String> call(
//								ConsumerRecord<String, String> record)
//								throws Exception {
//							return new Tuple2<>(StringUtils.trimToEmpty(record.value()), StringUtils.trimToEmpty(record.value()));
//						}
//
//					});
            JavaPairDStream<String, String> words = inputDStream
                    .mapToPair(record -> {
                        return new Tuple2<>(StringUtils.trimToEmpty(record.value()), StringUtils.trimToEmpty(record.value()));
                    });

            // 7. 统计在窗口时间内单词被搜索次数，每5分钟滑动一次窗口，统计5分钟内单词被搜索的次数
            words.map((value) -> value._2())
                    .filter((word) -> {// 去掉空格
                        if (StringUtils.isBlank(word)) {
                            return false;
                        }
                        return true;
                    })
                    .countByValueAndWindow(new Duration(5 * 60 * 1000),
                            new Duration(5 * 60 * 1000))
                    .foreachRDD(records -> {
                        println(records.sortByKey(false).take(10));
                    });
//					.foreachRDD(new VoidFunction<JavaPairRDD<String, Long>>() {// 对统计结果进行排序取出排名前10的热搜词,并打印输出
//								@Override
//								public void call(JavaPairRDD<String, Long> words)
//										throws Exception {
//									List<Tuple2<String, Long>> wordCountList = words
//											.sortByKey(false).take(10);// 降序排名，取排名前10的热搜词
//									if (CollectionUtils.isNotEmpty(wordCountList)) {
//										println(wordCountList);// 排序并输出统计结果
//									}
//								}
//							});
            streamContext.start();
            streamContext.awaitTermination();
        } catch (InterruptedException e) {
            if (null != streamContext) {
                streamContext.close();
            }
        }
    }

    /**
     * 初始化KafkaConsumer配置
     *
     * @return
     */
    public static Map<String, Object> initKafkaConsumerConf() {
        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put("bootstrap.servers", "server-1:9092,server-2:9092");
        kafkaParams.put("key.deserializer", StringDeserializer.class);
        kafkaParams.put("value.deserializer", StringDeserializer.class);
        kafkaParams.put("group.id", "words-top-search");
        kafkaParams.put("auto.offset.reset", "latest");
        kafkaParams.put("enable.auto.commit", false);
        return kafkaParams;
    }

    /**
     * 打印统计结果
     *
     * @param wordCountList
     */
    public static void println(List<Tuple2<String, Long>> wordCountList) {
        if (CollectionUtils.isNotEmpty(wordCountList)) {
            List<Tuple2<String, Long>> sortList = new ArrayList<Tuple2<String, Long>>(
                    wordCountList);
            sortList.sort(new Comparator<Tuple2<String, Long>>() {//降序排列
                @Override
                public int compare(Tuple2<String, Long> t1,
                                   Tuple2<String, Long> t2) {
                    if (t2._2.compareTo(t1._2) > 0) {
                        return 1;
                    } else if (t2._2.compareTo(t1._2) < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
            //输出统计结果
            System.out.println("=====================================");
            System.out.println("时间：["
                    + DateFormatUtils.format(
                    new Date(System.currentTimeMillis()),
                    "yyyy-MM-dd HH:mm:ss") + "],热搜词如下：");
            for (Tuple2<String, Long> wordCount : sortList) {
                System.out.println(wordCount._1 + ":" + wordCount._2);
            }
            System.out.println("=====================================");
        }
    }

}