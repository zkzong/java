package com.zkzong.sb.security2.sysmanager.service;

import com.zkzong.sb.security2.sysmanager.entity.AclUser;
import com.zkzong.sb.security2.core.security.BaseService;

/**
 * Created by Zong on 2017/5/31.
 */
public interface AclUserService extends BaseService<AclUser> {
    AclUser findAclUserByName(String userName);
}
