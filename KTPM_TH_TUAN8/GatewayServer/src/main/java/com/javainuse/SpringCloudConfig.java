package com.javainuse;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/chuyenbay/**")
                        .uri("http://localhost:8081/")
                        .id("chuyenBayService"))

                .route(r -> r.path("/baymay/**")
                        .uri("http://localhost:8082/")
                        .id("mayBayService"))
                .build();
    }


}
