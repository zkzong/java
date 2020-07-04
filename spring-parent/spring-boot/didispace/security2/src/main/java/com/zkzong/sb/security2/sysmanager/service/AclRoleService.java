package com.zkzong.sb.security2.sysmanager.service;

import com.zkzong.sb.security2.core.security.BaseService;
import com.zkzong.sb.security2.sysmanager.entity.AclRole;

/**
 * Created by Zong on 2017/6/2.
 */
public interface AclRoleService extends BaseService<AclRole> {
    String findAclRolesByAclUserRoleIds(String roleIds);
}
