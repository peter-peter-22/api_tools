package com.example.api_tools.configuration;

import com.example.api_tools.dto.ErrorResponse;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiGrouping {
    // Add the default error schema everywhere
    public OpenApiCustomizer errorResponseCustomizer() {
        return openApi -> {
            // Register the error schema
            openApi.getComponents().getSchemas().putAll(ModelConverters.getInstance().read(ErrorResponse.class));

            // Resolve the schema once (efficient)
            Schema errorSchema = new Schema();
            errorSchema.setName("ErrorResponse");
            errorSchema.set$ref("#/components/schemas/ErrorResponse");

            // Build the ApiResponse
            MediaType mediaType = new MediaType().schema(errorSchema);
            Content content = new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, mediaType);
            ApiResponse badRequestResponse = new ApiResponse()
                    .description("Standard error format")
                    .content(content);

            // Add the created ApiResponse for all paths
            openApi.getPaths().values().forEach(pathItem ->
                    pathItem.readOperations().forEach(operation ->
                            operation.getResponses().addApiResponse("400", badRequestResponse)
                    )
            );
        };
    }

    @Bean
    public GroupedOpenApi usersApi() {
        return GroupedOpenApi.builder()
                .group("frontend")  // Group name (appears in Swagger UI dropdown)
                .pathsToMatch("/api/users/**", "/api/orders/**")  // Include only these paths
                // .packagesToScan("com.example.demo.controller.users")  // Alternative: by package
                // For tag-based: .addOpenApiMethodFilter(method -> method.getTags().contains("users"))
                .addOpenApiCustomizer(errorResponseCustomizer())
                .build();
    }

    @Bean
    public GroupedOpenApi ordersApi() {
        return GroupedOpenApi.builder()
                .group("dashboard")
                .pathsToMatch("/api/metrics")
                // .addOpenApiMethodFilter(method -> method.getTags().contains("orders"))  // If using tags
                .addOpenApiCustomizer(errorResponseCustomizer())
                .build();
    }
}