package com.bramli.gatewayservice.configuration;


import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    /*@Bean
    RouteLocator routeLocator (RouteLocatorBuilder builder){
        return builder.routes()
                .route((r)->r.path("r1","/customers/**")
                        .uri("lb://customer"))
                .route((r)->r.path("r2","/products/**")
                        .uri("lb://inventory")).build();

    }*/
    @Bean
   DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties){
        return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
    }
}
