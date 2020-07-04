package com.zkzong.retry.example2;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author rollenholt
 */
@Service
public class Service2 {

    public void test() {
        final RetryTemplate retryTemplate = new RetryTemplate();
        final SimpleRetryPolicy policy = new SimpleRetryPolicy(3, Collections.<Class<? extends Throwable>, Boolean>
                singletonMap(Exception.class, true));
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(100);
        retryTemplate.setRetryPolicy(policy);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        final RetryCallback<Object, Exception> retryCallback = new RetryCallback<Object, Exception>() {
            @Override
            public Object doWithRetry(RetryContext context) throws Exception {
                System.out.println("do some thing");
                //设置context一些属性,给RecoveryCallback传递一些属性
                context.setAttribute("key1", "value1");
                System.out.println(context.getRetryCount());
                throw new Exception("exception");
//                return null;
            }
        };

        // 如果RetryCallback执行出现指定异常, 并且超过最大重试次数依旧出现指定异常的话,就执行RecoveryCallback动作
        final RecoveryCallback<Object> recoveryCallback = new RecoveryCallback<Object>() {
            @Override
            public Object recover(RetryContext context) throws Exception {
                System.out.println("do recory operation");
                System.out.println(context.getAttribute("key1"));
                return null;
            }
        };

        try {
            final Object execute = retryTemplate.execute(retryCallback, recoveryCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
