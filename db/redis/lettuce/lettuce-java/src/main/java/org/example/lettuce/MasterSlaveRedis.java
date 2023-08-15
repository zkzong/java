package com.example.lettuce;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.codec.Utf8StringCodec;
import io.lettuce.core.masterslave.MasterSlave;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;

/**
 * @Author: zong
 * @Date: 2020/1/7
 */
public class MasterSlaveRedis {

    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create();

        StatefulRedisMasterSlaveConnection<String, String> connection
                = MasterSlave.connect(redisClient,
                new Utf8StringCodec(), RedisURI.create("redis://localhost"));

        connection.setReadFrom(ReadFrom.SLAVE);
    }
}
