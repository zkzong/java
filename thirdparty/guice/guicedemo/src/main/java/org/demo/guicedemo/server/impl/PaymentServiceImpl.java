package org.demo.guicedemo.server.impl;

import com.google.common.cache.Cache;
import org.demo.guicedemo.Logged;
import org.demo.guicedemo.server.PaymentService;

import javax.inject.Inject;

public class PaymentServiceImpl implements PaymentService {
    private final Cache<String, String> cache;

    @Inject
    public PaymentServiceImpl(Cache<String, String> cache) {
        super();
        this.cache = cache;
    }

    @Override
    @Logged
    public void pay(long orderId, long price, Long sessionId) {
        // TODO Auto-generated method stub
    }

    void putCache(String key, String value) {
        cache.put(key, value);
    }
}
