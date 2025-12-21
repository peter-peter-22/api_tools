package com.example.api_tools.configuration;

import com.example.api_tools.dto.ErrorResponse;
import io.swagger.v3.core.util.AnnotationsUtils;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenApiCustomizer errorResponseCustomizer() {
        // Resolve the schema once (efficient)
        Schema errorSchema = AnnotationsUtils.resolveSchemaFromType(
                ErrorResponse.class, new Components(), null);

        // Create a content from the schema, similarly to in the ApiResponse
        MediaType mediaType = new MediaType().schema(errorSchema);
        Content content = new Content().addMediaType("application/json", mediaType);

        // Build a complete ApiResponse
        ApiResponse badRequestResponse = new ApiResponse()
                .description("Validation or business error")
                .content(content);

        // Add the created ApiResponse for all paths
        return openApi -> openApi.getPaths().values().forEach(pathItem ->
                pathItem.readOperations().forEach(operation ->
                        operation.getResponses().addApiResponse("400", badRequestResponse)
                )
        );
    }
}