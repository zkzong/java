package com.zkzong.ss.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {
        Set<String> result = new LinkedHashSet<>();
        // between and 的起始值
        int lower = rangeShardingValue.getValueRange().lowerEndpoint();
        int upper = rangeShardingValue.getValueRange().upperEndpoint();
        // 循环范围计算分库逻辑
        for (int i = lower; i <= upper; i++) {
            for (String databaseName : collection) {
                if (databaseName.endsWith(i % collection.size() + "")) {
                    result.add(databaseName);
                }
            }
        }
        return result;
    }
}
