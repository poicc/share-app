package com.crq.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/22 11:01
 */
//@Configuration
public class RoutesConfiguration {

    //    @Bean
//    public RouteLocator declare(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("id-001", route -> route.path("/user/**")
//                        .and().method(HttpMethod.GET)
//                        .uri("http://localhost:8081"))
//                .build();
//    }
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("rewrite_request_obj", r -> r.path("/api/v1/user/**")
//                        .filters(f -> f.stripPrefix(2)
//                                .cacheRequestBody(String.class).uri("http://localhost:8081")).build();
//    }

    static class Hello {
        String message;

        public Hello() {
        }

        public Hello(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
