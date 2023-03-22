package com.spring.cloud.gateway.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Flux;

import java.nio.charset.StandardCharsets;

@Slf4j
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {
    @Autowired
    private RedisUtils redisUtils;

    public AuthGatewayFilterFactory() {
        super(Config.class);
    }

    @Autowired
    private ModifyResponseBodyGatewayFilterFactory modifyResponseBodyGatewayFilterFactory;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 具体的过滤逻辑
     * 1.如果没有登录令牌token，直接返回没有授权的信息
     * 2.如果有登录令牌token
     * 2.1通过令牌校验，继续向下执行
     * 2.2没有通过校验，返回没有通过校验的原因
     *
     * @param config 自定义配置类
     * @return 网关过滤器
     */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String token = exchange.getRequest().getHeaders().getFirst("Authorization");
            ServerHttpResponse resp = exchange.getResponse();
            resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            try {
                if (!exchange.getRequest().getPath().toString().contains("admin/login")) {
                    if (StrUtil.isBlank(token) || JwtUtils.getAppTokenKey(token) == null || !token.equals(redisUtils.get(JwtUtils.getAppTokenKey(token)))) {
                        String result = JSONUtil.parseObj(R.fail(ErrorCodeEnum.TOKEN_ERROR.getCode(), "token error")).toStringPretty();
                        DataBuffer buffer = resp.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
                        return resp.writeWith(Flux.just(buffer));
                    }
                }
                return chain.filter(exchange.mutate().build());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                String result = JSONUtil.parseObj(R.fail(ErrorCodeEnum.TOKEN_ERROR.getCode(), e.getMessage())).toStringPretty();
                DataBuffer buffer = resp.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
                return resp.writeWith(Flux.just(buffer));
            }
        };
    }

    /**
     * 自定义配置类
     */
    public static class Config {
    }

}
