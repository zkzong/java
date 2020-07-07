package com.zkzong.sb.security2.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.entity.BaseEntity;
import com.zkzong.sb.security2.sysmanager.mapper.AclRoleResourcesMapper;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Zong on 2017/5/31.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclroleresources")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclRoleResourcesMapper.class)
public class AclRoleResources extends BaseEntity {
    @Column
    private Integer roleId;
    @Column
    private String resourceIds;
    @Transient
    private String resourceNames;

    public AclRoleResources() {
    }

    public AclRoleResources(Integer roleId, String resourceIds) {
        this.roleId = roleId;
        this.resourceIds = resourceIds;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(String resourceNames) {
        this.resourceNames = resourceNames;
    }
}
