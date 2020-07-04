package com.zkzong.sb.security2.sysmanager.mapper;

import com.zkzong.sb.security2.sysmanager.entity.AclRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Zong on 2017/6/2.
 */
public interface AclRoleMapper extends Mapper<AclRole> {
    @Select("SELECT GROUP_CONCAT(aclrole.pronoun) as pronoun FROM tbl_sysmgr_aclrole as aclrole where INSTR(CONCAT(',',#{roleIds},','),CONCAT(',',aclrole.id,','))")
    String findAclRolesByAclUserRoleIds(String roleIds);
}
