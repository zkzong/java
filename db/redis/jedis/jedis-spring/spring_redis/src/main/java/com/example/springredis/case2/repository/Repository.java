package com.example.springredis.case2.repository;

import com.example.springredis.case2.domain.DomainObject;

import java.util.List;

/**
 * Created by Zong on 2017/3/4.
 */
public interface Repository<V extends DomainObject> {
    void put(V obj);
    V get(V key);
    void delete(V key);
    List<V> getObjects();
}
