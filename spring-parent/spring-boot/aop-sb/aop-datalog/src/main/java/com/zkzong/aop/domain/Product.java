package com.zkzong.aop.domain;

import com.zkzong.aop.datalog.Datalog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Datalog(name = "产品名称")
    private String name;

    private String category;
    private String detail;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private String provider;
    private Date onlineTime;
    private Date updateTime;
}
