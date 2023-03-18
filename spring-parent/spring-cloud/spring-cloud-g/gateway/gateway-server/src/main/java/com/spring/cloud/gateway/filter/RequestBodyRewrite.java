package com.spring.cloud.gateway.filter;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSON;
import com.spring.cloud.gateway.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class RequestBodyRewrite implements RewriteFunction<String, String> {

    AES aes = SecureUtil.aes("scgatewaygateway".getBytes());

    @Override
    public Publisher<String> apply(ServerWebExchange serverWebExchange, String body) {
        try {
            log.info("body = {}", body);
            ServerHttpRequest request = serverWebExchange.getRequest();
            HttpHeaders headers = request.getHeaders();
            if (headers.containsKey("encrypt")) {
                // 解密请求参数
                UserReq userReq = JSON.parseObject(body, UserReq.class);
                String data = aes.decryptStr(userReq.getEncryptData());
                return Mono.just(data);
            } else {
                return Mono.just(body);
            }

        } catch (Exception ex) {
            log.error("1. json process fail", ex);
            return Mono.error(new Exception("1. json process fail", ex));
        }
    }
}
