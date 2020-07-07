package com.zkzong.sb.security2.core.service.impl;

import com.zkzong.sb.security2.core.dao.BaseDao;
import com.zkzong.sb.security2.core.dao.impl.MyBatisBaseDaoImpl;
import com.zkzong.sb.security2.core.entity.BaseEntity;
import com.zkzong.sb.security2.core.service.BaseService;
import com.zkzong.sb.security2.core.util.GenericeClassUtils;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zong on 2017/6/2.
 */
public class MyBatisBaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
    protected Class<T> entityClass = GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);

    protected <M extends Mapper<T>> M getMapper(Class cls) {
        return ((MyBatisBaseDaoImpl<T>) baseDao).getMapper(cls);
    }

    @Resource(name = "myBatisBaseDao")
    private BaseDao<T> baseDao;

    @Override
    public T getEntityById(Integer id) {
        return baseDao.getEntityById(entityClass, id);
    }

    @Override
    public void addEntity(T entity) {
        baseDao.addEntity(entity);
    }

    @Override
    public void updateEntity(T entity) {
        baseDao.updateEntity(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        baseDao.deleteEntityById(entityClass, id);
    }

    @Override
    public List<T> selectAll() {
        return baseDao.selectAll(entityClass);
    }
}
