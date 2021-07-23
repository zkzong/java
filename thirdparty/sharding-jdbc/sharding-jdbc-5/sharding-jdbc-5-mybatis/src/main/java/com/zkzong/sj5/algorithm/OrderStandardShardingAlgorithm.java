package com.zkzong.sj5.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderStandardShardingAlgorithm implements StandardShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        //for (String each : collection) {
        int value = preciseShardingValue.getValue().intValue();
        int i = value % 2;
        String[] tables = collection.toArray(new String[]{});
        return tables[i];
        //}
        //return null;
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        Set<String> result = new LinkedHashSet<>();
        // between and 的起始值
        long lower = 0;
        long upper = 0;
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        if (valueRange.hasLowerBound()) {
            lower = valueRange.lowerEndpoint();
        }
        if (valueRange.hasUpperBound()) {
            upper = valueRange.upperEndpoint();
        }

        String[] tables = collection.toArray(new String[]{});
        // 循环范围计算分库逻辑
        for (long i = lower; i <= upper; i++) {
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

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return null;
    }
}
