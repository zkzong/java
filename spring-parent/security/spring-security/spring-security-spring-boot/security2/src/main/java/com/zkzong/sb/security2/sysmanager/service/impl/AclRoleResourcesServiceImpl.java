package com.zkzong.sb.security2.sysmanager.service.impl;

import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.service.impl.MyBatisBaseServiceImpl;
import com.zkzong.sb.security2.sysmanager.entity.AclRoleResources;
import com.zkzong.sb.security2.sysmanager.mapper.AclRoleResourcesMapper;
import com.zkzong.sb.security2.sysmanager.service.AclRoleResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Zong on 2017/6/2.
 */
@Service
@MapperClass(AclRoleResources.class)
public class AclRoleResourcesServiceImpl extends MyBatisBaseServiceImpl<AclRoleResources> implements AclRoleResourcesService {

    protected AclRoleResourcesMapper getMapper() {
        return super.getMapper(AclRoleResources.class);
    }

    @Override
    public String selectResourceIdsByRoleIds(String roleIds) {
        String resourceIds = this.getMapper().selectResourceIdsByRoleIds(roleIds);
        String[] resourceIdsArray = resourceIds.split(",");
        ArrayList<String> list = new ArrayList<>();
        for (String resourceId : resourceIdsArray) {
            if (!list.contains(resourceId)) {
                list.add(resourceId);
            }
        }
        return StringUtils.join(list.toArray(), ",");
    }
}
