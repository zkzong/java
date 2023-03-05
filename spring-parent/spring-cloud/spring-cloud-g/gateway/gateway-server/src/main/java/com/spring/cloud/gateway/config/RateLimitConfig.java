//package com.spring.cloud.gateway.config;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.spring.cloud.gateway.pojo.ResultMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//import java.util.concurrent.Callable;
//
//@Component
//public class RateLimitConfig {
//
//    // 注入Resilience4j限流器注册机
//    @Autowired
//    private RateLimiterRegistry rateLimiterRegistry = null;
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                // 设置请求路径满足ANT风格“/user/**”的路由
//                .route("user-service", r -> r.path("/user/**")
//                        // 添加自定义过滤器
//                        .filters(f -> f.filter(customGatewayFilter())) // ①
//                        // 匹配路径
//                        .uri("http://localhost:6001"))
//                .build();
//    }
//
//    /**
//     * 限流逻辑
//     *
//     * @return 是否放行结果
//     */
//    private ResultMessage rateLimit() {
//        // 获取Resilience4j限速器
//        RateLimiter userRateLimiter = rateLimiterRegistry.rateLimiter("user");
//        // 绑定限速器
//        Callable<ResultMessage> call
//                = RateLimiter.decorateCallable(userRateLimiter,
//                () -> new ResultMessage(true, "PASS")); // ①
//        // 尝试获取结果
//        Try<ResultMessage> tryResult = Try.of(() -> call.call())
//                // 降级逻辑
//                .recover(ex -> new ResultMessage(false, "TOO MANY REQUESTS")); // ②
//        ResultMessage result = tryResult.get();
//        return result;
//    }
//
//    /**
//     * 自定义Gateway过滤器
//     *
//     * @return Gateway过滤器
//     */
//    private GatewayFilter customGatewayFilter() {
//        return (exchange, chain) -> { // ①
//            // 执行Resilience4j限速器逻辑
//            ResultMessage resultMessage = rateLimit();
//            if (!resultMessage.getSuccess()) { // 不放行逻辑 ②
//                // 获取响应对象
//                ServerHttpResponse response = exchange.getResponse();
//                // 响应码为429——请求过多
//                response.setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
//                // 响应类型为JSON
//                response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
//                // 转换为JSON字符串
//                String body = toJson(resultMessage);
//                // 响应数据放入缓冲区
//                DataBuffer dataBuffer = response.bufferFactory().wrap(body.getBytes());
//                // 使用限流结果响应请求，不再继续执行过滤器链
//                return response.writeWith(Mono.just(dataBuffer));
//            }
//            // 放行，继续执行过滤器链
//            return chain.filter(exchange); // ③
//        };
//    }
//
//    /**
//     * 将结果消息转换为JSON字符串
//     *
//     * @param result -- 结果消息
//     * @return JSON字符串
//     */
//    private String toJson(ResultMessage result) {
//        ObjectMapper mapper = new ObjectMapper();
//        String body = null;
//        try {
//            body = mapper.writeValueAsString(result);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return body;
//    }
//
//}
