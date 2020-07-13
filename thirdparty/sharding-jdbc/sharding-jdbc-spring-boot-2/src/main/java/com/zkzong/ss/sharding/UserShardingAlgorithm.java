package com.zkzong.ss.sharding;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        Map map = shardingValue.getColumnNameAndShardingValuesMap();
        Collection<Integer> userIdCol = (Collection<Integer>) map.get("user_id");
        Integer userId = userIdCol.iterator().next();
        int remainder = userId % 2;
        String suffix = "_" + remainder;
        Collection<String> userNameCol = (Collection<String>) map.get("user_name");
        String userName = userNameCol.iterator().next();
        List<String> result = new ArrayList<>();
        for (Object tableNameObj : availableTargetNames) {
            String tableName = tableNameObj.toString();
            if (tableName.endsWith(suffix)) {
                result.add(tableName);
            }
        }
        return result;
    }
}
