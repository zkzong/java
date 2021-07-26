package com.zkzong.ss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_address")
public final class AddressEntity extends Address {

    private static final long serialVersionUID = 4743102234543827855L;

    @Id
    @Column(name = "address_id")
    @Override
    public Long getAddressId() {
        return super.getAddressId();
    }

    @Column(name = "address_name")
    @Override
    public String getAddressName() {
        return super.getAddressName();
    }
}
