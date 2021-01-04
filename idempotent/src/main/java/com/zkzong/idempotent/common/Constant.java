package com.zkzong.idempotent.common;

public class Constant {

    public static final int MAX_SIZE_PER_TIME = 1000;
    public static final int INDEX_ZERO = 0;
    public static final int NUMBER_ZERO = 0;
    public static final int NUMBER_ONE = 1;

    public interface Redis {
        String OK = "OK";
        // 过期时间, 60s, 一分钟
        Integer EXPIRE_TIME_MINUTE = 60;
        // 过期时间, 一小时
        Integer EXPIRE_TIME_HOUR = 60 * 60;
        // 过期时间, 一天
        Integer EXPIRE_TIME_DAY = 60 * 60 * 24;
        String TOKEN_PREFIX = "token:";
        String MSG_CONSUMER_PREFIX = "consumer:";
        String ACCESS_LIMIT_PREFIX = "accessLimit:";
    }

}

