package com.zkzong.sb2.model;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2020/1/11
 */
@Data
public class Request {

    private String action;
    private String smsType;
    private String apiVersion;
    private String content;
    private String fromNum;
    private String dateSent;
    private String deliverCode;
    private String recvTime;
    private String status;
    private String reqId;
    private String smsCount;

}
