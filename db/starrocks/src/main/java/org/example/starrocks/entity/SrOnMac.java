package org.example.starrocks.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("sr_on_mac")
public class SrOnMac {

    private Long c0;
    private Date c1;
    private Date c2;
    private String c3;

}
