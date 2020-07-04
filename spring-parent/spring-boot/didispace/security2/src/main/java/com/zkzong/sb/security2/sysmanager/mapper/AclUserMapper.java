package com.zkzong.sb.security2.sysmanager.mapper;

import com.zkzong.sb.security2.sysmanager.entity.AclUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Zong on 2017/5/31.
 */
public interface AclUserMapper extends Mapper<AclUser> {
    @Select("select * from tbl_sysmgr_acluser where user_name = #{userName}")
    AclUser findAclUserByName(String userName);
}
