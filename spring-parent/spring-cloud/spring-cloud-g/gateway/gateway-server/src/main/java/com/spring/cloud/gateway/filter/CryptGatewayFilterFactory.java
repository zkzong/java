package com.spring.cloud.gateway.filter;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.cloud.gateway.support.CachedBodyOutputMessage;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
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

@Slf4j
@Component
public class CryptGatewayFilterFactory extends AbstractGatewayFilterFactory {
    private final List<HttpMessageReader<?>> messageReaders;

    public CryptGatewayFilterFactory() {
        this.messageReaders = HandlerStrategies.withDefaults().messageReaders();
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerRequest serverRequest = ServerRequest.create(exchange, this.messageReaders);

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
                AtomicReference<String> result = new AtomicReference<>();
                body.subscribe(value -> result.set(SecureUtil.aes().decryptStr(value)),
                        e -> log.error(e.getMessage(), e)
                );
                return Mono.just(result.get());
            } catch (Exception e) {
                log.error("gateway parameter decryption exception", e);
                throw new RuntimeException("Parameter decryption exception");
            }
        };
    }

    private ServerHttpRequestDecorator decorate(ServerWebExchange exchange, HttpHeaders headers,
                                                CachedBodyOutputMessage outputMessage) {
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

}
