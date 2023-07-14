/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-14 PM 3:30
 */

package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {
    @Bean
    //  라우팅
    //  어떤식으로 요청을 사용자에게 다른 서버로 잘 보낼 것인지
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                //  http://localhost:8080/articles/**
                //  (/articles, /articles/{id}, /articles/{id}/comments)
                //  -> http://localhost:8082/articles/**
                .route("articles", predicate -> predicate
                        //  사용자가 보낸 요청의 Path
                        .path("/articles/**")
                        //  사용자의 요청을 전달할 Host
                        .uri("http://localhost:8082")
                )
                //  http://localhost:8080/auth/**
                //  -> http://localhost:8081/**
                .route("auth", predicate -> predicate
                        .path("/auth/**")
                        .filters(filter -> filter
                                //  정규표현식을 이용해 경로의 일부분을 추출
                                .rewritePath("/auth/(?<path>.*)", "/${path}")
                        )
                        .uri("http://localhost:8081/")
                )
                .build();
    }
}
