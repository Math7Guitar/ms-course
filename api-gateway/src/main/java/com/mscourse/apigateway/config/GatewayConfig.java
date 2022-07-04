package com.mscourse.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {       
        return builder.routes()
                      .route( p -> p.path("/get")
                        .filters( f -> f.addRequestHeader("Hello", "World")
                                        .addRequestParameter("Hello", "World"))
                                        .uri("http://httpbin.org:80"))
                      .route( p -> p.path("/hr-worker/**")
                                    .uri("lb://hr-worker"))
                      .route( p -> p.path("/hr-payroll/**")
                                    .uri("lb://hr-payroll"))
                      .build();
    }
    
}
