package com.zkzong.spring.data.redis.p_51cto;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Zong on 2017/5/18.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisTest {
    public static ApplicationContext ctx;
    public static JedisConnectionFactory jedisConnectionFactory;
    public JedisConnection jedisConnection;

    @BeforeClass
    public static void setBeforeClass() {
        ctx = new ClassPathXmlApplicationContext("spring-redis-51cto.xml");
        jedisConnectionFactory = (JedisConnectionFactory) ctx.getBean("jedisConnectionFactory");
    }

    @Before
    public void testBefore() {
        jedisConnection = jedisConnectionFactory.getConnection();
    }

    @After
    public void setAfter() {
        jedisConnection.close();
    }

    private void print(Collection<RedisServer> c) {
        for (Iterator<RedisServer> iter = c.iterator(); iter.hasNext();) {
            RedisServer rs = iter.next();
            System.out.println(rs.getHost() + ":" + rs.getPort());
        }
    }

    @Ignore
    @Test
    public void test1() {
        if (!jedisConnection.exists(new String("zz").getBytes())) {
            jedisConnection.set(new String("zz").getBytes(), new String("zz").getBytes());
        }
    }

    @Ignore
    @Test
    public void test2() {
        Set<byte[]> keys = jedisConnection.keys(new String("*").getBytes());
        for (Iterator<byte[]> iter = keys.iterator(); iter.hasNext();) {
            System.out.println(new String(iter.next()));
        }
    }

    /**
     * 哨兵
     */
    @Test
    public void test3() {
        if (jedisConnectionFactory.getSentinelConnection().isOpen()) {
            Collection<RedisServer> c = jedisConnectionFactory.getSentinelConnection().masters();
            print(c);

//            RedisNode rn = new RedisNode("10.129.39.90", 6379);
//            rn.setName("mymaster");
//            c = jedisConnectionFactory.getSentinelConnection().slaves(rn);
//            print(c);
        }
    }
}
