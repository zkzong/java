package com.spring.cloud.gateway.filter;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSON;
import com.spring.cloud.gateway.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

/**
 * Greenwich.RELEASE
 */
@Slf4j
public class DecryptRequestBodyGatewayFilterFactory extends AbstractGatewayFilterFactory implements Ordered {

    private AES aes = SecureUtil.aes("scgatewaygateway".getBytes());


    private final List<HttpMessageReader<?>> messageReaders;

    public DecryptRequestBodyGatewayFilterFactory() {
        this.messageReaders = HandlerStrategies.withDefaults().messageReaders();
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerRequest serverRequest = ServerRequest.create(exchange,
                    this.messageReaders);

            Mono<String> modifiedBody = serverRequest.bodyToMono(String.class)
                    .flatMap(originalBody -> modifyBody().apply(exchange, Mono.just(originalBody)));

            BodyInserter bodyInserter = BodyInserters.fromPublisher(modifiedBody, String.class);
            HttpHeaders headers = new HttpHeaders();
            headers.putAll(exchange.getRequest().getHeaders());
            headers.remove(HttpHeaders.CONTENT_LENGTH);
            CachedBodyOutputMessage outputMessage = new CachedBodyOutputMessage(exchange, headers);

            return bodyInserter.insert(outputMessage, new BodyInserterContext())
                    .then(Mono.defer(() -> {
                        ServerHttpRequest decorator = decorate(exchange, headers, outputMessage);
                        return chain.filter(exchange.mutate().request(decorator).build());
                    }));
        };
    }

    private BiFunction<ServerWebExchange, Mono<String>, Mono<String>> modifyBody() {
        return (exchange, body) -> {
            try {
                HttpHeaders headers = exchange.getRequest().getHeaders();
                AtomicReference<String> result = new AtomicReference<>();
                body.subscribe(value -> {
                            if (headers.containsKey("encrypt")) {
                                // 解密请求参数
                                UserReq userReq = JSON.parseObject(value, UserReq.class);
                                result.set(aes.decryptStr(userReq.getEncryptData()));
                            } else {
                                result.set(value);
                            }
                        },
                        e -> log.error(e.getMessage(), e)
                );
                return Mono.just(result.get());
            } catch (Exception e) {
                log.error("gateway parameter decryption exception", e);
                throw new RuntimeException("Parameter decryption exception");
            }
        };
    }

    private ServerHttpRequestDecorator decorate(ServerWebExchange exchange, HttpHeaders headers, CachedBodyOutputMessage outputMessage) {
        return new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public HttpHeaders getHeaders() {
                long contentLength = headers.getContentLength();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.putAll(super.getHeaders());
                if (contentLength > 0) {
                    httpHeaders.setContentLength(contentLength);
                } else {
                    httpHeaders.set(HttpHeaders.TRANSFER_ENCODING, "chunked");
                }
                return httpHeaders;
            }

            @Override
            public Flux<DataBuffer> getBody() {
                return outputMessage.getBody();
            }
        };

    }

    @Override
    public int getOrder() {
        return -2;
    }
}
