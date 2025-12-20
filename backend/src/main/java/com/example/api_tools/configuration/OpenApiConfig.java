package com.example.api_tools.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi usersApi() {
        return GroupedOpenApi.builder()
                .group("frontend")  // Group name (appears in Swagger UI dropdown)
                .pathsToMatch("/api/users/**", "/api/orders/**")  // Include only these paths
                // .packagesToScan("com.example.demo.controller.users")  // Alternative: by package
                // For tag-based: .addOpenApiMethodFilter(method -> method.getTags().contains("users"))
                .build();
    }

    @Bean
    public GroupedOpenApi ordersApi() {
        return GroupedOpenApi.builder()
                .group("dashboard")
                .pathsToMatch("/api/metrics")
                // .addOpenApiMethodFilter(method -> method.getTags().contains("orders"))  // If using tags
                .build();
    }
}