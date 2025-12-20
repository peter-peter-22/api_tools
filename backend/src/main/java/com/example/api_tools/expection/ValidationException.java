package com.example.api_tools.expection;

import lombok.Getter;

import java.util.Map;

@Getter
public class ValidationException extends RuntimeException {
    private final Map<String, String> errors;

    public ValidationException(Map<String, String> errors) {
        super("Custom validation failed");
        this.errors = errors;
    }
}