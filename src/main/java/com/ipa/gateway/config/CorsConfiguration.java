package com.ipa.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebFluxConfigurer corsConfigurer() {
        return new WebFluxConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                    .addMapping("/**")
                    .allowedOrigins("http://localhost:9000", "http://localhost:8100")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .exposedHeaders(
                        "Authorization",
                        "Link",
                        "X-Total-Count",
                        "X-ipaGatewayApp-alert",
                        "X-ipaGatewayApp-error",
                        "X-ipaGatewayApp-params"
                    )
                    .allowCredentials(true)
                    .maxAge(1800);
            }
        };
    }
}
