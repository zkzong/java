package com.zkzong.sb.security2.sysmanager.mapper;

import com.zkzong.sb.security2.sysmanager.entity.AclRequestType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Zong on 2017/6/2.
 */
public interface AclRequestTypeMapper extends Mapper<AclRequestType> {
    @Select("SELECT GROUP_CONCAT(aclrequesttype.pronoun) as pronoun FROM tbl_sysmgr_aclrequesttype as aclrequesttype where INSTR(CONCAT(',',#{requestTypeIds},','),CONCAT(',',aclrequesttype.id,','))")
    String findPronounStrByRequestTypeIds(String requestTypeIds);
}
