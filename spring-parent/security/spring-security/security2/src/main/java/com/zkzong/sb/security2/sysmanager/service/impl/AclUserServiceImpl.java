package com.zkzong.sb.security2.sysmanager.service.impl;

import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.service.impl.MyBatisBaseServiceImpl;
import com.zkzong.sb.security2.sysmanager.entity.AclUser;
import com.zkzong.sb.security2.sysmanager.mapper.AclUserMapper;
import com.zkzong.sb.security2.sysmanager.service.AclUserService;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/6/2.
 */
@Service
@MapperClass(AclUserMapper.class)
public class AclUserServiceImpl extends MyBatisBaseServiceImpl<AclUser> implements AclUserService {
    protected AclUserMapper getMapper() {
        return super.getMapper(AclUser.class);
    }

    @Override
    public AclUser findAclUserByName(String userName) {
        return getMapper().findAclUserByName(userName);
    }
}
