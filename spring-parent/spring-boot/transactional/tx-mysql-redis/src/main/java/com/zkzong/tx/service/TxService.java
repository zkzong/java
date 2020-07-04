package com.zkzong.tx.service;

/**
 * @Author: Zong
 * @Date: 2018/11/14
 */
public interface TxService {

    void insertAll(String name, int age);

    void insertMysqlThenRedis(String name, int age);

}
