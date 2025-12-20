package com.example.api_tools.controller;

import com.example.api_tools.dto.UsageMetrics;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metrics")
@Tag(name = "metrics", description = "Usage metric APIs")
public class MetricsController {
    @GetMapping
    public ResponseEntity<UsageMetrics> readMetrics() {
        return ResponseEntity.ok(new UsageMetrics(1234, 123456, 123));
    }
}
