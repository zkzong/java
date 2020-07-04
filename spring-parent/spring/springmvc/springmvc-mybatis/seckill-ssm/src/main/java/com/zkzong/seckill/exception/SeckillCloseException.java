package com.zkzong.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by zong on 17-5-6.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
