package com.zkzong.sb.security2.sysmanager.mapper;

import com.zkzong.sb.security2.sysmanager.entity.AclResources;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Zong on 2017/6/2.
 */
public interface AclResourcesMapper extends Mapper<AclResources> {

    @Select("SELECT resources.*,CONCAT('auth_',CONCAT((SELECT pronoun FROM tbl_sysmgr_aclresources WHERE id = resources.parent_id),'_'),requesttype.pronoun) AS authority FROM tbl_sysmgr_aclresources AS resources LEFT JOIN tbl_sysmgr_aclrequesttype AS requesttype ON resources.request_type_id = requesttype.id WHERE resources.type = 'R'")
    List<AclResources> selectAclResourcesTypeOfRequest();

    @Select("select * from tbl_sysmgr_aclresources where type=#{type}")
    List<AclResources> selectAclResourcesByType(String type);

    List<AclResources> selectAclResourcesByResourceIds(@Param("resourceIdsArray") String[] resourceIdsArray);
}
