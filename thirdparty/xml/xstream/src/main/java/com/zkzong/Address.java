package com.zkzong;

import lombok.Data;

@Data
public class Address {
    private String area;
    private String city;
    private String state;
    private String country;
    private int pincode;
}
