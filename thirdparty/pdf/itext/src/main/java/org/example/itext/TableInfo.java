package org.example.itext;

import java.math.BigDecimal;
import java.util.Date;

public class TableInfo {
    private int id;
    private String contractNo;
    private String loanNo;
    private String name;
    private String idNo;
    private String mobile;
    private BigDecimal loanAmount;
    private BigDecimal bankAmount;
    private BigDecimal orgAmount;
    private int term;
    private Date date1;
    private Date date2;
    private BigDecimal capitalAmount;
    private BigDecimal interestAmount;
    private BigDecimal penaltyAmount;
    private BigDecimal sumAmount;
    private BigDecimal zrAmount;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(BigDecimal bankAmount) {
        this.bankAmount = bankAmount;
    }

    public BigDecimal getOrgAmount() {
        return orgAmount;
    }

    public void setOrgAmount(BigDecimal orgAmount) {
        this.orgAmount = orgAmount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public BigDecimal getCapitalAmount() {
        return capitalAmount;
    }

    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public BigDecimal getZrAmount() {
        return zrAmount;
    }

    public void setZrAmount(BigDecimal zrAmount) {
        this.zrAmount = zrAmount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
