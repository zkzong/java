package com.kafka.action.chapter6.consumer;

import java.util.*;

/**
 * Description:消费者分区分配策略验证 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class ConsumerPatitionRangeTest {

    public static void main(String[] args) {

        List<String> consumersForTopic = new ArrayList<String>();
        consumersForTopic.add("aaa");
        consumersForTopic.add("bbb");
        consumersForTopic.add("ccc");
        consumersForTopic.add("ddd");
        consumersForTopic.add("eee");
        consumersForTopic.add("fff");
        consumersForTopic.add("ggg");
        Integer numPartitionsForTopic = 5;

        Collections.sort(consumersForTopic);

        int numPartitionsPerConsumer = numPartitionsForTopic / consumersForTopic.size();
        int consumersWithExtraPartition = numPartitionsForTopic % consumersForTopic.size();
        List<Integer> partitions = new ArrayList<Integer>();
        partitions.add(0);
        partitions.add(1);
        partitions.add(2);
        partitions.add(3);
        partitions.add(4);
        partitions.add(5);
        partitions.add(6);
        partitions.add(7);
        partitions.add(8);
        partitions.add(9);
        Map<String, List<Integer>> assignment = new HashMap<String, List<Integer>>();
        for (int i = 0, n = consumersForTopic.size(); i < n; i++) {
            int start = numPartitionsPerConsumer * i + Math.min(i, consumersWithExtraPartition);
            int length = numPartitionsPerConsumer + (i + 1 > consumersWithExtraPartition ? 0 : 1);
            assignment.put(consumersForTopic.get(i), partitions.subList(start, start + length));
        }
        for (Map.Entry<String, List<Integer>> entry : assignment.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }
}
