package com.zkzong.sb.security2.sysmanager.mapper;

import com.zkzong.sb.security2.sysmanager.entity.AclRoleResources;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Zong on 2017/5/31.
 */
public interface AclRoleResourcesMapper extends Mapper<AclRoleResources> {
    @Select("select group_concat(resource_ids) from tbl_sysmgr_aclroleresources where id in #{roleIds}")
    @ResultType(String.class)
    String selectResourceIdsByRoleIds(String roleIds);
}
