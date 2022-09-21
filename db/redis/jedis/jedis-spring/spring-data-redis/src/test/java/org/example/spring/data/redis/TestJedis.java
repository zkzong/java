package org.example.spring.data.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Zong on 2017/2/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-redis.xml"})
public class TestJedis {
    public static ApplicationContext ctx;
    public static JedisConnectionFactory jedisConnectionFactory;
    public JedisConnection jedisConnection;

    @BeforeClass
    public static void setBeforeClass() {
        ctx = new ClassPathXmlApplicationContext("spring-redis.xml");
        jedisConnectionFactory = (JedisConnectionFactory) ctx.getBean("jedisConnectionFactory");
    }

    @Before
    public void setBefore() {
        jedisConnection = (JedisConnection) jedisConnectionFactory.getConnection();
    }

    @After
    public void setAfter() {
        jedisConnection.close();
    }

    private void print(Collection<RedisServer> c) {
        for (Iterator<RedisServer> iter = c.iterator(); iter.hasNext(); ) {
            RedisServer rs =  iter.next();
            System.out.println(rs.getHost() + ":" + rs.getPort());
        }
    }

    // 简单测试JedisConnection
    @Ignore
    @Test
    public void test1() {
        if (!jedisConnection.exists(new String("zz").getBytes())) {
            jedisConnection.set(new String("zz").getBytes(),
                    new String("zz").getBytes());
        }
    }

}
