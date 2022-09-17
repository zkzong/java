package org.example.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.Date;

@RelationshipEntity
@Data
public class CustomerRelation {
    @Id
    @GeneratedValue
    private Long id;
    private Date createTime;
    private String remark;

    @StartNode
    private CustomerNode customerFrom;

    @EndNode
    private CustomerNode customerTo;

    public CustomerRelation(CustomerNode customerFrom, CustomerNode customerTo, String remark) {
        this.customerFrom = customerFrom;
        this.customerTo = customerTo;
        this.remark = remark;
    }
}
