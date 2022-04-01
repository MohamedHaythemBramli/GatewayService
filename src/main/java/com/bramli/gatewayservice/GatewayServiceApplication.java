package com.bramli.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	RouteLocator routeLocator (RouteLocatorBuilder builder){
		return builder.routes()
				.route((r)->r.path("r1","/customers/**")
						     .uri("http://localhost:8081/"))
				.route((r)->r.path("r2","/products/**")
						.uri("http://localhost:8082/")).build();

	}

}
