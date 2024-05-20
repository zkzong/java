package com.example;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zongz
 * @Date: 2024/5/20
 */
public class SlidingWindowRateLimiter {

    private static final String REDIS_KEY = "sliding_window_limiter";

    private static final int WINDOW_SIZE_SECONDS = 5;

    private static final int MAX_REQUESTS = 3;

    private Jedis jedis;

    public SlidingWindowRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis() / 1000;

        // 移除窗口外的数据
        jedis.zremrangeByScore(REDIS_KEY, Double.NEGATIVE_INFINITY, currentTime - WINDOW_SIZE_SECONDS);

        // 获取当前窗口内的请求数
        Long currentWindowRequests = jedis.zcard(REDIS_KEY);

        // 如果请求数超过限制，拒绝请求
        if (currentWindowRequests >= MAX_REQUESTS) {
            return false;
        }

        String requestId = UUID.randomUUID().toString();
        String member = userId + ":" + currentTime + ":" + requestId;
        // 添加当前请求到有序集合
        jedis.zadd(REDIS_KEY, currentTime, member);

        return true;
    }

    public boolean allowRequestWithLua(String userId) {
        long currentTime = System.currentTimeMillis() / 1000;
        String requestId = UUID.randomUUID().toString();
        String member = userId + ":" + currentTime + ":" + requestId;

        String luaScript = "local current_time = tonumber(ARGV[1])\n" +
                "local window_size = tonumber(ARGV[2])\n" +
                "local max_requests = tonumber(ARGV[3])\n" +
                "local current_window_requests = tonumber(redis.call('zcard', KEYS[1]))\n" +
                "redis.call('zremrangebyscore', KEYS[1], '-inf', current_time - window_size)\n" +
                "if current_window_requests >= max_requests then\n" +
                "    return 0\n" +
                "else\n" +
                "    redis.call('zadd', KEYS[1], current_time, ARGV[4])\n" +
                "    return 1\n" +
                "end";

        List<String> keys = Collections.singletonList(REDIS_KEY);
        List<String> args = Arrays.asList(String.valueOf(currentTime), String.valueOf(WINDOW_SIZE_SECONDS),
                String.valueOf(MAX_REQUESTS), member);
        Long result = (Long) jedis.eval(luaScript, keys, args);
        return result != null && result == 1;
    }

    public static void main(String[] args) throws InterruptedException {
        RedisClient redisClient = new RedisClient("127.0.0.1", 6379);
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(redisClient.getJedis());

        for (int i = 0; i < 150000; i++) {
            String userId = "user123";
            boolean allowed = rateLimiter.allowRequestWithLua(userId);
            System.out.println("Request #" + (i + 1) + " allowed " + allowed);
            Thread.sleep(1000);
        }
        redisClient.getJedis().close();
    }
}
