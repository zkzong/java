package com.lagou.warehouseservice.dto;

//库存商品对象
public class Stock {
    private Long skuId; //商品品类编号
    private String title; //商品与品类名称
    private Integer quantity; //库存数量
    private String unit; //单位
    private String description; //描述信息

    //带参构造函数
    public Stock(Long skuId, String title, Integer quantity, String unit) {
        this.skuId = skuId;
        this.title = title;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
