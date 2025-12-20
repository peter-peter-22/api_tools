package com.example.api_tools.controller;

import com.example.api_tools.dto.ErrorResponse;
import com.example.api_tools.dto.UserCreateRequest;
import com.example.api_tools.expection.ValidationException;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/users")
@Validated
@Tag(name = "users", description = "User management APIs")
public class UserController {

    private final List<User> users = new CopyOnWriteArrayList<>();
    private long idCounter = 1;

    private boolean usernameTaken(String name) {
        for (User user : users) {
            if (Objects.equals(user.getName(), name))
                return true;
        }
        return false;
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest request) {
        User user = new User(idCounter++, request.name(), request.email(), request.age());
        if (usernameTaken(user.getName()))
            throw new ValidationException(Map.of("name", "This name is taken"));
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(users);
    }
}

