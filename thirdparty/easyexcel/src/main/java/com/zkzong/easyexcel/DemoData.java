package com.zkzong.easyexcel;

import lombok.Data;

import java.util.Date;

/**
 * 基础数据类.这里的排序和excel里面的排序一致
 **/
@Data
public class DemoData {
    private String string;
    private Date date;
    //@ExcelProperty(index = 5)
    private Double doubleData;
}
