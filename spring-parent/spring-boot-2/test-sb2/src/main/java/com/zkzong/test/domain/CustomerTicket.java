package com.zkzong.test.domain;

import lombok.Data;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "customer_ticket")
public class CustomerTicket {

    @Id
    @GeneratedValue
    private Long id;
    private Long accountId;
    private String orderNumber;
    private String description;
    private Date createTime;

    public CustomerTicket() {
        super();
    }

    public CustomerTicket(Long accountId, String orderNumber) {

        super();

        Assert.notNull(accountId, "Account Id must not be null");
        Assert.notNull(orderNumber, "Order Number must not be null");
        Assert.isTrue(orderNumber.length() == 10, "Order Number must be exactly 10 characters");

        this.accountId = accountId;
        this.orderNumber = orderNumber;

    }

    public CustomerTicket(Long accountId, String orderNumber, String description, Date createTime) {

        this(accountId, orderNumber);

        this.description = description;
        this.createTime = createTime;
    }

    public CustomerTicket(Long id, Long accountId, String orderNumber, String description, Date createTime) {

        this(accountId, orderNumber);

        this.id = id;
        this.description = description;
        this.createTime = createTime;
    }

}

