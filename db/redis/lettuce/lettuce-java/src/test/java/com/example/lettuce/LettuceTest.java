package com.example.lettuce;

import io.lettuce.core.LettuceFutures;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.TransactionResult;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zong
 * @Date: 2020/1/7
 */
public class LettuceTest {

    private StatefulRedisConnection<String, String> connection;

    @Before
    public void before() {
        RedisURI redisURI = new RedisURI();
        redisURI.setHost("127.0.0.1");
        redisURI.setPort(6379);
        redisURI.setDatabase(0);
        redisURI.setPassword("redis");
        RedisClient redisClient = RedisClient.create(redisURI);
        //RedisClient redisClient = RedisClient.create("redis://localhost:6379/");
        connection = redisClient.connect();
    }

    @Test
    public void sync() {
        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set("key", "Hello, Redis!");
        String value = syncCommands.get("key");
        System.out.println(value);

        syncCommands.hset("recordName", "FirstName", "John");
        syncCommands.hset("recordName", "LastName", "Smith");
        Map<String, String> record = syncCommands.hgetall("recordName");
        System.out.println(record);
    }

    @Test
    public void async() {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        RedisFuture<String> result = asyncCommands.get("key");
    }

    @Test
    public void reactive() {
        RedisStringReactiveCommands<String, String> reactiveCommands = connection.reactive();
    }

    @Test
    public void list() {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        asyncCommands.lpush("tasks", "firstTask");
        asyncCommands.lpush("tasks", "secondTask");
        RedisFuture<String> redisFuture = asyncCommands.rpop("tasks");

        try {
            String nextTask = redisFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        asyncCommands.del("tasks");
        asyncCommands.lpush("tasks", "firstTask");
        asyncCommands.lpush("tasks", "secondTask");
        redisFuture = asyncCommands.lpop("tasks");

        try {
            String nextTask = redisFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sets() {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        asyncCommands.sadd("pets", "dog");
        asyncCommands.sadd("pets", "cat");
        asyncCommands.sadd("pets", "cat");

        RedisFuture<Set<String>> pets = asyncCommands.smembers("nicknames");
        RedisFuture<Boolean> exists = asyncCommands.sismember("pets", "dog");
    }

    @Test
    public void hashes() {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        asyncCommands.hset("recordName", "FirstName", "John");
        asyncCommands.hset("recordName", "LastName", "Smith");

        RedisFuture<String> lastName = asyncCommands.hget("recordName", "LastName");
        RedisFuture<Map<String, String>> record = asyncCommands.hgetall("recordName");
    }

    @Test
    public void sortedsets() {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        asyncCommands.zadd("sortedset", 1, "one");
        asyncCommands.zadd("sortedset", 4, "zero");
        asyncCommands.zadd("sortedset", 2, "two");

        String key = "sortedset";
        RedisFuture<List<String>> valuesForward = asyncCommands.zrange(key, 0, 3);
        RedisFuture<List<String>> valuesReverse = asyncCommands.zrevrange(key, 0, 3);
    }

    @Test
    public void transactions() throws ExecutionException, InterruptedException {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        asyncCommands.multi();

        RedisFuture<String> result1 = asyncCommands.set("key1", "value1");
        RedisFuture<String> result2 = asyncCommands.set("key2", "value2");
        RedisFuture<String> result3 = asyncCommands.set("key3", "value3");

        RedisFuture<TransactionResult> execResult = asyncCommands.exec();

        TransactionResult transactionResult = execResult.get();

        String firstResult = transactionResult.get(0);
        String secondResult = transactionResult.get(0);
        String thirdResult = transactionResult.get(0);
    }

    @Test
    public void batching() {
        RedisAsyncCommands<String, String> commands = connection.async();
        commands.setAutoFlushCommands(false);

        List<RedisFuture<?>> futures = new ArrayList<>();
        for (int i = 0; i < futures.size(); i++) {
            futures.add(commands.set("key-" + i, "value-" + i));
        }
        commands.flushCommands();

        boolean result = LettuceFutures.awaitAll(5, TimeUnit.SECONDS,
                futures.toArray(new RedisFuture[0]));
        System.out.println(result);
    }
}
