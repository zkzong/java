package com.zkzong.aop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeItem {
    private String field;
    private String fieldShowName;
    private String oldValue;
    private String newValue;
}
