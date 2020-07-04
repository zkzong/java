package com.zkzong.sb.security2.core.service;

import com.zkzong.sb.security2.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by Zong on 2017/6/2.
 */
public interface BaseService<T extends BaseEntity> {
    T getEntityById(final Integer id);

    void addEntity(final T entity);

    void updateEntity(final T entity);

    void deleteEntityById(final Integer id);

    List<T> selectAll();
}
