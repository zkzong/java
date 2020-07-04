package com.zkzong.sb.security2.sysmanager.service.impl;

import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.service.impl.MyBatisBaseServiceImpl;
import com.zkzong.sb.security2.sysmanager.entity.AclResources;
import com.zkzong.sb.security2.sysmanager.mapper.AclResourcesMapper;
import com.zkzong.sb.security2.sysmanager.service.AclResourcesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zong on 2017/6/2.
 */
@Service
@MapperClass(AclResourcesMapper.class)
public class AclResourcesServiceImpl extends MyBatisBaseServiceImpl<AclResources> implements AclResourcesService {
    protected AclResourcesMapper getMapper() {
        return super.getMapper(AclResources.class);
    }

    @Override
    public List<AclResources> selectAclResourcesTypeOfRequest() {
        return getMapper().selectAclResourcesTypeOfRequest();
    }

    @Override
    public List<AclResources> selectAclResourcesByResourceIds(String resourceIds) {
        return getMapper().selectAclResourcesByResourceIds(resourceIds.split(","));
    }
}
