package org.example.jedis.redisinaction;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created by Zong on 2016/12/21.
 */
public class Chapter02 {
    public static void main(String[] args) {
        new Chapter02().run();
    }

    public void run() {
        Jedis conn = new Jedis("localhost");
        conn.select(15);

        testLoginCookies(conn);
    }

    public void testLoginCookies(Jedis conn) {
        System.out.println("-----testLoginCookies-----");
        String token = UUID.randomUUID().toString();

        updateToken(conn, token, "username", "itemX");
    }

    public void updateToken(Jedis conn, String token, String user, String item) {
        long timestamp = System.currentTimeMillis() / 1000;
        conn.hset("login:", token, user);
        conn.zadd("recent:", timestamp, token);
        if (item != null) {
            conn.zadd("viewed:" + token, timestamp, item);
            conn.zremrangeByRank("viewed:" + token, 0, -26);
            conn.zincrby("viewed:", -1, item);
        }
    }
}
