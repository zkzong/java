package org.example.guava;

/**
 * @Author: zong
 * @Date: 2020/1/9
 */
public enum ResultEnum {
    SUCCESS("0000", "成功"),
    FAIL("9999", "失败");

    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
