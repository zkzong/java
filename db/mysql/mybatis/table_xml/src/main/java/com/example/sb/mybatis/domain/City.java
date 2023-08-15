package com.example.sb.mybatis.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Zong on 2017/6/5.
 */
@Data
@ToString
public class City {
    private Long id;
    private Long provinceId;
    private String cityName;
    private String description;
}
