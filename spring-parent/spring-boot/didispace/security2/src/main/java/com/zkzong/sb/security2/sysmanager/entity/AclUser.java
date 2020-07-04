package com.zkzong.sb.security2.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.entity.BaseEntity;
import com.zkzong.sb.security2.sysmanager.mapper.AclUserMapper;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Zong on 2017/5/31.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_acluser")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclUserMapper.class)
public class AclUser extends BaseEntity {

    @Column
    private String userName;
    @Column
    private String userPwd;
    @Column
    private String roleIds;
    @Column
    private String roleNames;
    @Transient
    private String rolesesArray;

    public AclUser() {
    }

    public AclUser(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getRolesesArray() {
        return rolesesArray;
    }

    public void setRolesesArray(String rolesesArray) {
        this.rolesesArray = rolesesArray;
    }
}
