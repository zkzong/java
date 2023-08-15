package com.example.aop.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Action {
    private String id;
    private Long objectId;
    private String objectClass;
    private String operator;
    private Date operateTime;
    private ActionType actionType;
    private List<ChangeItem> changes = new ArrayList<>();
}
