package com.example.api_tools.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Request to create a new user")
public record UserCreateRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50)
        @Schema(description = "Full name", example = "John Doe")
        String name,

        @NotBlank
        @Email(message = "Invalid email format")
        @Schema(description = "Email address", example = "john@example.com", type = "string", format = "email")
        String email,

        @NotNull
        @Min(18)
        @Schema(description = "Age must be 18+", example = "25")
        Integer age
) {
}
