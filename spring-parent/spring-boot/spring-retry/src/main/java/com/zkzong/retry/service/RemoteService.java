package com.zkzong.retry.service;

import com.zkzong.retry.pojo.User;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/7/12.
 */
@Service
public class RemoteService {
    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 3, backoff = @Backoff(delay = 5000L, multiplier = 1))
    public void call(User user) {
        System.out.println(user);
        System.out.println("do something...");
        throw new RemoteAccessException("RPC调用异常");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
        System.out.println("RemoteAccessException Recover");
    }

    @Recover
    public void recover(RuntimeException e) {
        System.out.println("RuntimeException Recover");
    }
}
