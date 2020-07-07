package com.zkzong.sb.security2.sysmanager.service;

import com.zkzong.sb.security2.core.security.BaseService;
import com.zkzong.sb.security2.sysmanager.entity.AclResources;

import java.util.List;

/**
 * Created by Zong on 2017/5/31.
 */
public interface AclResourcesService extends BaseService<AclResources> {
    List<AclResources> selectAclResourcesTypeOfRequest();

    List<AclResources> selectAclResourcesByResourceIds(String resourceIds);
}
