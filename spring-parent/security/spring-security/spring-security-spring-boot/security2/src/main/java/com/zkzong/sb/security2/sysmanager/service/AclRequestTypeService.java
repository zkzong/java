package com.zkzong.sb.security2.sysmanager.service;

import com.zkzong.sb.security2.core.security.BaseService;
import com.zkzong.sb.security2.sysmanager.entity.AclRequestType;

/**
 * Created by Zong on 2017/6/2.
 */
public interface AclRequestTypeService extends BaseService<AclRequestType> {
    String findPronounStrByRequestTypeIds(String requestTypeIds);

    int selectCountByNeId(AclRequestType aclRequestType);
}
