package com.example.jedis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by zong on 2017/3/2.
 * jedis 简单使用
 */
public class JedisSimpleTest {
    private Jedis jedis;

    /**
     * 初始化连接
     */
    @Before
    public void beforeClass() {
        jedis = new Jedis("127.0.0.1");
        jedis.auth("zong");
    }

    /**
     * 新增
     */
    @Test
    public void testSet() {
        jedis.set("blog", "zong");
    }

    /**
     * 获取
     */
    @Test
    public void testGet() {
        System.out.println(jedis.get("blog"));
    }

    /**
     * 重命名key
     */
    @Test
    public void testRenameKey() {
        jedis.rename("blog", "blog_new");
    }

    /**
     * 按key删除
     */
    @Test
    public void testDel() {
        jedis.del("blog_new");
    }

    /**
     * 获取所有key
     */
    @Test
    public void testKeys() {
        System.out.println(jedis.keys("*"));
    }

    @Test
    public void testSetnx() {
        // setnx：将key的值设为value，当且仅当key不存在
        jedis.setnx("nx", "nx");
        jedis.setnx("nx", "nxnx");
        System.out.println(jedis.get("nx")); // nx
    }

    @Test
    public void testIncr() {
        // setnx：将key的值设为value，当且仅当key不存在
        jedis.setex("incr", 30, "1");
        jedis.incr("incr");
        String count = jedis.get("incr");
        System.out.println(count); // 2
    }

}