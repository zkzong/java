package org.example.sb2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zong
 * @Date: 2022/3/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {

    /**
     * 代码
     */
    private String code;

    /**
     * 结果
     */
    private String msg;
}
