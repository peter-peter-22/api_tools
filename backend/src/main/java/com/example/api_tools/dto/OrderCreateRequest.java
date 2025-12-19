package com.example.api_tools.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Request to create a new order by a user")
public record OrderCreateRequest(
        @NotBlank
        Long id,
        @NotBlank
        Long itemId,
        @NotBlank
        Long userId,
        @NotBlank
        Integer count
) {
}
