package com.spring.cloud.gateway.filter;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class ResponseBodyRewrite implements RewriteFunction<String, String> {

    AES aes = SecureUtil.aes("scgatewaygateway".getBytes());
    @Override
    public Publisher<String> apply(ServerWebExchange serverWebExchange, String body) {
        try {
            ServerHttpRequest request = serverWebExchange.getRequest();
            HttpHeaders headers = request.getHeaders();
            if (headers.containsKey("encrypt")) {
                // 加密返回结果
                String data = aes.encryptHex(body);
                return Mono.just(data);
            } else {
                return Mono.just(body);
            }
        } catch (Exception ex) {
            log.error("2. json process fail", ex);
            return Mono.error(new Exception("2. json process fail", ex));
        }
    }
}
