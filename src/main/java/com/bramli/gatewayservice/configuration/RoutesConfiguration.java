package com.bramli.gatewayservice.configuration;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {
    @Bean
    RouteLocator routeLocator (RouteLocatorBuilder builder){
        return builder.routes()
                .route((r)->r.path("r1","/customers/**")
                        .uri("http://localhost:8081/"))
                .route((r)->r.path("r2","/products/**")
                        .uri("http://localhost:8082/")).build();

    }

}
