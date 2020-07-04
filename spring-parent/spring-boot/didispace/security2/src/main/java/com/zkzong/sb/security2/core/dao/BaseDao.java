package com.zkzong.sb.security2.core.dao;

import com.zkzong.sb.security2.core.dto.FlexiPageDto;
import com.zkzong.sb.security2.core.entity.BaseEntity;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Zong on 2017/6/2.
 */
public interface BaseDao<T extends BaseEntity> {
    T getEntityById(final Class<T> cls, final Integer id);

    void addEntity(final T entity);

    void updateEntity(final T entity);

    void deleteEntityById(final Class<T> cls, final Integer id);

    List<T> selectAll(Class<T> cls);

    List<T> findByLike(Example example);

    List<T> findByPage(Example example, FlexiPageDto flexiPageDto);

    int findRowCount(Example example);
}
