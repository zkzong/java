package com.zkzong.sj4.algorithm;

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

        String[] tables = collection.toArray(new String[]{});
        // 循环范围计算分库逻辑
        for (int i = lower; i <= upper; i++) {
            //for (String tableName : collection) {
            //    if (tableName.endsWith(i % collection.size() + "")) {
            //        result.add(tableName);
            //    }
            //}
            if (i % 2 == 0) {
                result.add(tables[0]);
            } else {
                result.add(tables[1]);
            }
        }
        return result;
    }
}
