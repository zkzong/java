package com.zkzong.sb.security2.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.entity.BaseEntity;
import com.zkzong.sb.security2.sysmanager.mapper.AclRoleMapper;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Zong on 2017/6/2.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclrole")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclRoleMapper.class)
public class AclRole extends BaseEntity {
    @Column
    private String roleName;
    @Column
    private String pronoun;

    public AclRole() {
    }

    public AclRole(String roleName, String pronoun) {
        this.roleName = roleName;
        this.pronoun = pronoun;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }
}
