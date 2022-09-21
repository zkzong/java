package org.example.sb.dto;

import lombok.Data;
import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.text.MessageFormat;

@Data
public class RspDTO<T> implements Serializable {

    private static int PARAM_FAIL_CODE = 1002;

    private T data;
    private Integer code;
    private String msg;

    private static final long serialVersionUID = 1L;

    public RspDTO() {
    }

    public RspDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RspDTO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RspDTO error() {
        return new RspDTO(HttpStatus.SC_INTERNAL_SERVER_ERROR, "系统繁忙,请稍后再试");
    }


    public static RspDTO paramFail(String msg) {
        return new RspDTO(PARAM_FAIL_CODE, msg);
    }


    public static RspDTO success() {
        return new RspDTO(HttpStatus.SC_OK, "success");
    }

    public static RspDTO failed() {
        return new RspDTO(HttpStatus.SC_INTERNAL_SERVER_ERROR, "failed");
    }

    public RspDTO<T> success(T data) {
        return new RspDTO<>(HttpStatus.SC_OK, "success", data);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}[{1}]", this.code, this.msg);
    }
}
