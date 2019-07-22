package org.demo.guicedemo.server.impl;

import com.google.common.cache.Cache;
import org.demo.guicedemo.server.PriceService;

import javax.inject.Inject;
import java.util.Set;

public class PriceServiceImpl implements PriceService {
    private final Set<String> supportedCurrencies;
    private final Cache<String, String> cache;

    @Inject
    public PriceServiceImpl(
            Set<String> supportedCurrencies,
            Cache<String, String> cache) {
        super();
        this.supportedCurrencies = supportedCurrencies;
        this.cache = cache;
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    @Override
    public long getPrice(long orderId) {
        throw new UnsupportedOperationException();
    }

    String getCachedValue(String key) {
        return cache.getIfPresent(key);
    }
}
