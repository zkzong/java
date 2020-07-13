package com.zkzong.sj3.jpa.service;

public interface OrderService {

    void insertOrder();

    void findDistinctByUserId(Integer userId);
}
