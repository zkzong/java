package com.zkzong.sc;

import org.springframework.stereotype.Component;

@Component
public class DcClientFallback implements DcClient {

    @Override
    public String consumer() {
        return "fallback";
    }
}
