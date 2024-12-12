package com.example.map.service;

/**
 * @Author: zongz
 * @Date: 2024-12-12
 */
public enum ServiceEnum {

    AUDI("audi", "audiService"),
    BMW("bmw", "bmwService");

    private String brand;
    private String service;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    ServiceEnum(String brand, String service) {
        this.brand = brand;
        this.service = service;
    }

    public static ServiceEnum getServiceEnum(String brand) {
        for (ServiceEnum serviceEnum : ServiceEnum.values()) {
            if (serviceEnum.brand.equals(brand)) {
                return serviceEnum;
            }
        }
        return null;
    }


}
