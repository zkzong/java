
package org.example.sj5.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    private Long addressId;

    private String addressName;

}
