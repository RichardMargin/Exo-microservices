package com.example.serviceproxy.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/patients/**")
                                .uri("lb://patient")
                )
                .route(r -> r.path("/medecins/**")
                        .uri("lb://medecin")
                )
                .route(r -> r.path("/rdvs/**")
                        .uri("lb://rdv")
                )
                .route(r -> r.path("/consultations/**")
                        .uri("lb://rdv")
                )
                .build();

    }
}
