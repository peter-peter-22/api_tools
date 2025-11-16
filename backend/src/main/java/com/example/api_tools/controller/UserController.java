package com.example.api_tools.controller;

import com.example.api_tools.dto.UserCreateRequest;
import com.example.api_tools.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/users")
@Validated
@Tag(name = "Users", description = "User management APIs")
public class UserController {

    private final List<User> users = new CopyOnWriteArrayList<>();
    private long idCounter = 1;

    @PostMapping
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest request) {
        User user = new User(idCounter++, request.name(), request.email(), request.age());
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }
}
