package com.zkzong.sb.security2.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.zkzong.sb.security2.core.annotation.MapperClass;
import com.zkzong.sb.security2.core.entity.BaseEntity;
import com.zkzong.sb.security2.sysmanager.mapper.AclResourcesMapper;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Zong on 2017/6/2.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclresources")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclResourcesMapper.class)
public class AclResources extends BaseEntity {
    @Column
    private String url;
    @Column
    private String type;
    @Column
    private String name;
    @Column
    private String pronoun;
    @Column
    private Integer parentId;
    @Column
    private Integer requestTypeId;
    @Transient
    private String authority;

    public AclResources() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(Integer requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
