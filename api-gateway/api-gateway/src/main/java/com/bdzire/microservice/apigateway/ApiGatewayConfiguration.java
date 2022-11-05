package com.bdzire.microservice.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/users/**")
						.uri("lb://user-service"))
				.route(p -> p.path("/products/**")
						.uri("lb://product-service"))
				.route(p -> p.path("/orders/**")
						.uri("lb://order-service"))
				.build();
	}

}
