package com.zkzong.sb.mybatis.req;

import lombok.Data;

import java.util.List;

@Data
public class NameInReq {

    private List<String> names;
    private String name;

}
