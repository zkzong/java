package com.example.snowflake;

import struqt.util.UniqueIdGenerator;

/**
 * @Author: zkzong
 * @Date: 2018.8.16
 */
public class IdGenerator {

    private static UniqueIdGenerator idGenerator = new UniqueIdGenerator(Long.MAX_VALUE);

    public static long generateId() {
        System.out.println("hashCode = " + idGenerator.hashCode());
        return idGenerator.next();
    }
}
