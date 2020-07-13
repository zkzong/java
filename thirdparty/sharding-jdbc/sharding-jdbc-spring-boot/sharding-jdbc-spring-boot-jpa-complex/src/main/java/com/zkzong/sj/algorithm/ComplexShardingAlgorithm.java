package com.zkzong.sj.algorithm;

import com.alibaba.fastjson.JSON;
import io.shardingjdbc.core.api.algorithm.sharding.ListShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.ShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
@Slf4j
public class ComplexShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {
        log.info("collection:" + JSON.toJSONString(availableTargetNames) + ",shardingValues:" + JSON.toJSONString(shardingValues));

        Iterator<ShardingValue> iterator = shardingValues.iterator();
        List<String> result = new ArrayList<>();
        String logicTableName = null;
        String appId = null;
        int num = 0;
        while (iterator.hasNext()) {
            ShardingValue next = iterator.next();
            if (next instanceof ListShardingValue) {
                ListShardingValue shardingValue = (ListShardingValue) next;
                logicTableName = next.getLogicTableName();
                String columnName = shardingValue.getColumnName();
                Collection values = shardingValue.getValues();
                if ("app_id".equals(columnName)) {
                    appId = values.iterator().next().toString();
                }
                if ("num".equals(columnName)) {
                    num = Integer.parseInt(values.iterator().next().toString());
                }
            }
        }
        if ("1001".equals(appId)) {
            if (num % 2 == 0) {
                result.add(logicTableName + "_0");
            } else {
                result.add(logicTableName + "_1");
            }
        }
        if ("1002".equals(appId)) {
            if (num % 2 == 0) {
                result.add(logicTableName + "_2");
            } else {
                result.add(logicTableName + "_3");
            }
        }

        return result;
    }

}
