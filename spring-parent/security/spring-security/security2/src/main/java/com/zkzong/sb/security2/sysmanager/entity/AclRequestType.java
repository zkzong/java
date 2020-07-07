package com.zkzong.sb.security2.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.entity.BaseEntity;
import com.zkzong.sb.security2.sysmanager.mapper.AclRequestTypeMapper;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Zong on 2017/6/2.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclrequesttype")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclRequestTypeMapper.class)
public class AclRequestType extends BaseEntity {
    @Column
    private String name;
    @Column
    private String pronoun;

    public AclRequestType() {
    }

    public AclRequestType(String name, String pronoun) {
        this.name = name;
        this.pronoun = pronoun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }
}
