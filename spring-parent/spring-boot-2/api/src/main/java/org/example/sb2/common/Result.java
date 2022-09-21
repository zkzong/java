package org.example.sb2.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zong
 * @Date: 2022/3/21
 */
@Data
public class Result implements Serializable {

    private Integer code;

    private String message;

    private ResultCode resultCode;

    private Object data;

    public Result() {
    }

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 返回失败
     *
     * @return
     */
    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    /**
     * 返回失败
     *
     * @return
     */
    public static Result success(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

}
