package com.zkzong.redisson;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

public class RedissonReplicated {
    public static void main(String[] args) {
        Config config = new Config();

        //指定编码，默认编码为org.redisson.codec.JsonJacksonCodec
        //之前使用的spring-data-redis，用的客户端jedis，编码为org.springframework.data.redis.serializer.StringRedisSerializer
        //改用redisson后为了之间数据能兼容，这里修改编码为org.redisson.client.codec.StringCodec
        config.setCodec(new StringCodec());

        config.useReplicatedServers()
                // 主节点变化扫描间隔时间
                .setScanInterval(2000)
                //设置云服务商的redis服务IP和端口，目前支持亚马逊云的AWS ElastiCache和微软云的Azure Redis 缓存
                .addNodeAddress("redis://123.57.221.104.1:6379")
                .addNodeAddress("redis://123.57.221.105:6380")
                .addNodeAddress("redis://123.57.221.106:6382");

        //设置密码
        //config.setPassword("password")
        //设置对于master节点的连接池中连接数最大为500
        config.useReplicatedServers().setMasterConnectionPoolSize(500);
        //设置对于slave节点的连接池中连接数最大为500
        config.useReplicatedServers().setSlaveConnectionPoolSize(500);
        //如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
        config.useReplicatedServers().setIdleConnectionTimeout(10000);
        //同任何节点建立连接时的等待超时。时间单位是毫秒。
        config.useReplicatedServers().setConnectTimeout(30000);
        //等待节点回复命令的时间。该时间从命令发送成功时开始计时。
        config.useReplicatedServers().setTimeout(3000);
        config.useReplicatedServers().setPingTimeout(30000);
        //当与某个节点的连接断开时，等待与其重新建立连接的时间间隔。时间单位是毫秒。
        config.useReplicatedServers().setReconnectionTimeout(3000);

        //创建客户端(发现创建RedissonClient非常耗时，基本在2秒-4秒左右)
        RedissonClient redisson = Redisson.create(config);

        //首先获取redis中的key-value对象，key不存在没关系
        RBucket<String> keyObject = redisson.getBucket("key");
        //如果key存在，就设置key的值为新值value
        //如果key不存在，就设置key的值为value
        keyObject.set("value");

        //最后关闭RedissonClient
        redisson.shutdown();
    }
}
