package com.zkzong.lombok;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Builder
@ToString
public class Car {
    private String make;
    private String model;
    private String bodyType;
    private int yearOfManufacture;
    private int cubicCapacity;
    @Singular("serviceDate")
    private List<LocalDate> serviceDate;
}
