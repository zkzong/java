package com.zkzong.shiro.service;

import com.zkzong.shiro.entity.Resource;

import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ResourceService {

    Resource createResource(Resource resource);

    Resource updateResource(Resource resource);

    void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);

    List<Resource> findAll();

    /**
     * 得到资源对应的权限字符串
     *
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     *
     * @param permissions
     * @return
     */
    List<Resource> findMenus(Set<String> permissions);
}