package com.zkzong.sb.security2.sysmanager.service.impl;

import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.service.impl.MyBatisBaseServiceImpl;
import com.zkzong.sb.security2.sysmanager.entity.AclRole;
import com.zkzong.sb.security2.sysmanager.mapper.AclRoleMapper;
import com.zkzong.sb.security2.sysmanager.service.AclRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/6/2.
 */
@Service
@MapperClass(AclRoleMapper.class)
public class AclRoleServiceImpl extends MyBatisBaseServiceImpl<AclRole> implements AclRoleService {
    protected AclRoleMapper getMapper() {
        return super.getMapper(AclRole.class);
    }

    @Override
    public String findAclRolesByAclUserRoleIds(String roleIds) {
        return this.getMapper().findAclRolesByAclUserRoleIds(roleIds);
    }
}
