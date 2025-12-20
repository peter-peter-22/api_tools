package com.example.api_tools.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;
import java.util.Optional;

@Schema(description = "Standard API error response")
public record ErrorResponse(
        String message,
        Map<String, String> errors,
        Optional<String> code // for possible i18n integration
) {
    public ErrorResponse(String message, String code) {
        this(message, null, Optional.of(code));
    }

    public ErrorResponse(String message) {
        this(message, null, Optional.empty());
    }

    public ErrorResponse(
            String message,
            Map<String, String> errors
    ) {
        this(message, errors, Optional.empty());
    }
}