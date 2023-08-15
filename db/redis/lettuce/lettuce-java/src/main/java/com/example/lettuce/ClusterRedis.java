package com.example.lettuce;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

/**
 * @Author: zong
 * @Date: 2020/1/7
 */
public class ClusterRedis {
    public static void main(String[] args) {
        RedisURI redisUri = RedisURI.Builder.redis("localhost")
                .withPassword("authentication").build();
        RedisClusterClient clusterClient = RedisClusterClient.create(redisUri);
        StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
        RedisAdvancedClusterCommands<String, String> syncCommands = connection.sync();
    }
}
