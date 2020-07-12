package com.zkzong.sb.security2.sysmanager.service.impl;

import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.service.impl.MyBatisBaseServiceImpl;
import com.zkzong.sb.security2.sysmanager.entity.AclRequestType;
import com.zkzong.sb.security2.sysmanager.mapper.AclRequestTypeMapper;
import com.zkzong.sb.security2.sysmanager.service.AclRequestTypeService;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/6/2.
 */
@Service
@MapperClass(AclRequestType.class)
public class AclRequestTypeServiceImpl extends MyBatisBaseServiceImpl<AclRequestType> implements AclRequestTypeService {

    protected AclRequestTypeMapper getMapper() {
        return super.getMapper(AclRequestType.class);
    }

    @Override
    public String findPronounStrByRequestTypeIds(String requestTypeIds) {
        return this.getMapper().findPronounStrByRequestTypeIds(requestTypeIds);
    }

    @Override
    public int selectCountByNeId(AclRequestType aclRequestType) {
        return 0;
    }
}
