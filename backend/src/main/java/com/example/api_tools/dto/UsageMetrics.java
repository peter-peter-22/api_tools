package com.example.api_tools.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Page usage analytics for the admin dashboard")
public record UsageMetrics(
        int users,
        int visits,
        int orders
) {
}
