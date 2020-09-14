package com.zkzong.idempotent;

import lombok.Data;

/**
 * @Description: http请求最外层对象
 */
@Data
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;


    public static ResultVo getFailedResult(int i, String message) {
        ResultVo<Object> resultVO = new ResultVo<>();
        resultVO.setCode(i);
        resultVO.setMessage(message);
        return resultVO;
    }

    public static ResultVo getSuccessResult(String businessResult) {
        ResultVo<Object> resultVO = new ResultVo<>();
        resultVO.setCode(200);
        resultVO.setMessage(businessResult);
        return resultVO;
    }
}
