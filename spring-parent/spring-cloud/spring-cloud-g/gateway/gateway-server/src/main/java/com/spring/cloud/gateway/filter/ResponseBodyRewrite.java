package com.spring.cloud.gateway.filter;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSON;
import com.spring.cloud.gateway.req.User;
import com.spring.cloud.gateway.resp.UserResp;
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

                // 组装返回值
                UserResp<User> userResp = new UserResp<>();
                userResp.setEncryptData(data);
                String s = aes.decryptStr(data);
                User user = JSON.parseObject(s, User.class);
                userResp.setData(user);
                return Mono.just(JSON.toJSONString(userResp));
            } else {
                return Mono.just(body);
            }
        } catch (Exception ex) {
            log.error("2. json process fail", ex);
            return Mono.error(new Exception("2. json process fail", ex));
        }
    }
}
