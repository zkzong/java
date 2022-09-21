/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.BYCDAO.com.
 * Developer Web Site: http://open.BYCDAO.com.
 */

package org.example.knife4j.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2017/07/03 14:58
 */
public class ReqEntity {
    @ApiModelProperty(value = "姓名", required = true)
    private String name;
    @ApiModelProperty(value = "电话号码", example = "555", required = true)
    private String tel;

    private List<WorkExperience> workExperiences = new ArrayList<>();


    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
