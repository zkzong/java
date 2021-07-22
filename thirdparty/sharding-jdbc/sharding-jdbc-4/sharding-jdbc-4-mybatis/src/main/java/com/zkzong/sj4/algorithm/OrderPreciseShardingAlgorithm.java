package com.zkzong.sj4.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class OrderPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        //for (String each : collection) {
        //    if (each.endsWith(preciseShardingValue.getValue() % 2 + "")) {
        //        return each;
        //    }
        //}
        //throw new UnsupportedOperationException();
        for (String each : collection) {
            int value = preciseShardingValue.getValue().intValue();
            int i = value % 2;
            String[] tables = collection.toArray(new String[]{});
            return tables[i];
        }
        return null;
    }

}
