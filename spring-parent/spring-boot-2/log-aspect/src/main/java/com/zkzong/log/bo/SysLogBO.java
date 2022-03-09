package com.zkzong.log.bo;

import lombok.Data;

/**
 * 系统日志bo
 *
 * @Author: zong
 * @Date: 2022/3/9
 */
@Data
public class SysLogBO {

    private String className;

    private String methodName;

    private String params;

    private Long exeuTime;

    private String remark;

    private String createDate;

}
