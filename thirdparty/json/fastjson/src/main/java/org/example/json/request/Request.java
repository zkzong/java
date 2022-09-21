package org.example.json.request;

/**
 * @Author: zong
 * @Date: 2020/1/11
 */
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

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setFromNum(String fromNum) {
        this.fromNum = fromNum;
    }

    public String getFromNum() {
        return fromNum;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setRecvTime(String recvTime) {
        this.recvTime = recvTime;
    }

    public String getRecvTime() {
        return recvTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setSmsCount(String smsCount) {
        this.smsCount = smsCount;
    }

    public String getSmsCount() {
        return smsCount;
    }

}
