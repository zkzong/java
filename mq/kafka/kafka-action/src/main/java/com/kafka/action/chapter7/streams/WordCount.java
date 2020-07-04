package com.kafka.action.chapter7.streams;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;

import java.util.Arrays;

/**
 * Description: 单词统计<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class WordCount {

    public static void main(String[] args) {
        // 序列化/反序列化Sting和Long类型
        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();

        // 通过指定输入topic “streams-file-input”来构造KStream实例，
        // 输入数据就以文本的形式保存在topic “streams-file-input” 中。
        // (在本示例中，我们忽略所有消息的key.)
        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> textLines = builder.stream(stringSerde,
                stringSerde, "streams-file-input");

        KTable<String, Long> wordCounts = textLines
                // 以空格为分隔符，将每行文本数据拆分成多个单词。
                // 这些文本行就是从输入topic中读到的每行消息的Value。
                // 我们使用flatMapValues方法来处理每个消息Value，而不是更通用的flatMap
                .flatMapValues(
                        value -> Arrays.asList(value.toLowerCase()
                                .split("\\s+")))
                // 我们随后将调用countByKey来计算每个单词出现的次数
                // 所以我们将每个单词作为map的key。
                .map((key, value) -> new KeyValue<>(value, value)).groupByKey()
                .count("");
        // 通过key来统计每个单词的次数
        //
        // 这会将流类型从KStream<String,String>转为KTable<String,Long>
        // (word-count).
        // 因此我们必须提供String和long的序列化反序列化方法。
        //

        // 转化KTable<String,Long>到KStream<String,Long>

        // 将KStream<String,Long>写入到输出topic中。
        wordCounts.to(stringSerde, longSerde, "streams-wordcount-output");
    }
}
