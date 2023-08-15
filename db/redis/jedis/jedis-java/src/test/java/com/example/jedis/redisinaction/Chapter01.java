package com.example.jedis.redisinaction;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2016/12/20.
 */
public class Chapter01 {
    private static final int ONE_WEEK_IN_SECOND = 7 * 86400;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    public static void main(String[] args) {
        new Chapter01().run();
    }

    public void run() {
        Jedis conn = new Jedis("localhost");
        // 切换到指定的数据库
        conn.select(15);

        String articleId = postArticle(conn, "username", "A title", "http://www.google.com");
        System.out.println("We posted a new article with id: " + articleId);
        System.out.println("Its HASH looks like:");

        Map<String, String> articleData = conn.hgetAll("article:" + articleId);
        for (Map.Entry<String, String> entry : articleData.entrySet()) {
            System.out.println("  " + entry.getKey() + ":" + entry.getValue());
        }

        System.out.println();
    }

    private String postArticle(Jedis conn, String user, String title, String link) {
        String articleId = String.valueOf(conn.incr("article:"));

        String voted = "voted:" + articleId;
        conn.sadd(voted, user);
        conn.expire(voted, ONE_WEEK_IN_SECOND);

        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        HashMap<String, String> articleData = new HashMap<String, String>();
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("user", user);
        articleData.put("now", String.valueOf(now));
        articleData.put("votes", "1");
        conn.hmset(article, articleData);
        conn.zadd("score:", now + VOTE_SCORE, article);
        conn.zadd("time:", now, article);

        return articleId;
    }

}
